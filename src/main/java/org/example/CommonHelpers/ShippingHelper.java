package org.example.CommonHelpers;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.apache.commons.lang3.tuple.Pair;
import org.example.Adapters.DateAdapter;
import org.example.Adapters.LocalDateTimeAdapter;
import org.example.Models.CommunicationModels.CarrierModels.*;
import org.example.Models.CommunicationModels.CarrierModels.Package;
import org.example.Models.RequestModels.ApiRequestModels.PickupLocationRequestModel;
import org.example.Models.RequestModels.ApiRequestModels.SalesOrderRequestModel;
import org.example.Models.ResponseModels.Response;
import org.example.Models.ResponseModels.ShippingResponseModels.*;

import org.apache.commons.lang3.StringUtils;
import java.util.stream.Collectors;

public class ShippingHelper {
    private final String _apiUrl = "https://apiv2.shiprocket.in/v1/external";
    private final String _email;
    private final String _password;

    public ShippingHelper(String email, String password) {
        this._email = email;
        this._password = password;
    }

    public <T> Response<T> httpResponse(
            String token,
            String url,
            String methodType,
            Type type,
            Object content,
            String successMessage) {
        try{
            HttpClient client = HttpClient.newHttpClient();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .registerTypeAdapter(Date.class, new DateAdapter())
                    .create();

            String requestBody = content != null ? gson.toJson(content) : "";

            var request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Content-Type", "application/json")
                    .method(methodType, HttpRequest.BodyPublishers.ofString(requestBody));

            if(org.springframework.util.StringUtils.hasText(token)){
                request.header("Authorization", "Bearer " + token);
            }

            HttpResponse<String> response = client.send(request.build(), HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200) {
                Response<T> res = new Response<>();
                res.setItem(gson.fromJson(response.body(), type));
                res.setSuccess(true);
                res.setMessage(successMessage);
                return res;
            }
            else{
                Response<T> res = new Response<>();
                res.setSuccess(false);
                res.setMessage(response.body());
                return res;
            }
        }
        catch (Exception e){
            return new Response<>(false, "Exception occurred: " + e, null);
        }
    }

    // <editor-fold desc="Packaging Estimate Algorithm">
    public List<PackagingEstimateResponseModel> getPackagingEstimate(Map<Product, Integer> productQuantityMappings , List<Package> packagesAvailable) throws Exception {
        /* Step 1: Get the total volume to be fit*/
        double totalVol= 0;
        for(Map.Entry<Product, Integer> productQuantityMapping : productQuantityMappings.entrySet()) {
            totalVol += (productQuantityMapping.getKey().getLength() * productQuantityMapping.getKey().getBreadth() * productQuantityMapping.getKey().getHeight()) * productQuantityMapping.getValue();
        }
        totalVol = Math.ceil(totalVol);

        /* Step 2: Sort products from high to low volume with each quantity being an individual product*/
        List<Product> productsToFit = new ArrayList<>(){
            @Override
            public boolean add(Product product) {
                double productVolume = product.getLength() * product.getBreadth() * product.getHeight();
                int insertIndex = 0;

                for (; insertIndex < size(); insertIndex++) {
                    Product currentProduct = get(insertIndex);
                    double currentProductVolume = currentProduct.getLength() * currentProduct.getBreadth() * currentProduct.getHeight();
                    if (productVolume > currentProductVolume) {
                        break;
                    }
                }

                super.add(insertIndex, product);
                return true;
            }
        };
        for(Map.Entry<Product, Integer> productQuantityMapping : productQuantityMappings.entrySet()) {
            for(int i = 0; i<productQuantityMapping.getValue(); i++) {
                productsToFit.add(productQuantityMapping.getKey());
            }
        }

        /* Step 3: Sort packages from low to high */
        List<Package> packages = new ArrayList<>(){
            @Override
            public boolean add(Package _package) {
                double packageVolume = _package.getLength() * _package.getBreadth() * _package.getHeight();
                int insertIndex = 0;

                for (; insertIndex < size(); insertIndex++) {
                    Package currentPackage = get(insertIndex);
                    double currentPackageVolume = currentPackage.getLength() * currentPackage.getBreadth() * currentPackage.getHeight();
                    if (packageVolume < currentPackageVolume) {
                        break;
                    }
                }

                super.add(insertIndex, _package);
                return true;
            }
        };
        for(Package _package : packagesAvailable) {
            for(int i = 0; i<_package.getQuantity(); i++) {
                packages.add(_package);
            }
        }

        /* Step 4: create mappings productId to product and packageId to package */
        Map<Long, Product> productIdProductMapping = new HashMap<>();
        Map<Long, Package> packageIdPackageMapping = new HashMap<>();
        for(Product product : productsToFit) {
            productIdProductMapping.putIfAbsent(product.getProductId(), product);
        }
        for(Package _package: packagesAvailable) {
            packageIdPackageMapping.putIfAbsent(_package.getPackageId(), _package);
        }

        List<PackagingEstimateResponseModel> trueResult = new ArrayList<>(){
            @Override
            public boolean add(PackagingEstimateResponseModel packagingEstimateResponseModel) {
                Package _package = packageIdPackageMapping.get(packagingEstimateResponseModel.getPackageId());
                double packageVolume = _package.getLength() * _package.getBreadth() * _package.getHeight();
                int insertIndex = 0;

                for (; insertIndex < size(); insertIndex++) {
                    PackagingEstimateResponseModel currentResult = get(insertIndex);
                    Package currentPackage = packageIdPackageMapping.get(currentResult.getPackageId());
                    double currentPackageVolume = currentPackage.getLength() * currentPackage.getBreadth() * currentPackage.getHeight();
                    if (packageVolume > currentPackageVolume) {
                        break;
                    }
                }

                super.add(insertIndex, packagingEstimateResponseModel);
                return true;
            }
        };
        for(Package _package : packagesAvailable) {
            for(int i = 0; i<_package.getQuantity(); i++) {
                packages.add(_package);
            }
        }

        /* Step 5: Check the totalVol and get the next biggest volume box available */
        /* Step 6: Iterate through the products and put the product in the selected package */
        for(Product product : productsToFit) {
            // check if there is any space left in any of the packages that are already used - select the package with biggest volume left.
            Package nextLargestPackage = getNextLargestUsedPackage(product, trueResult, packageIdPackageMapping, productIdProductMapping);
            if(nextLargestPackage == null) {
                nextLargestPackage = getNextLargestPackage(packages, totalVol);

                // decrease the quantity of that package by 1
                nextLargestPackage.setQuantity(nextLargestPackage.getQuantity() - 1);

                // add it to trueResult
                List<Long> productIds = new ArrayList<>();
                productIds.add(product.getProductId());
                PackagingEstimateResponseModel packagingEstimateResponseModel = new PackagingEstimateResponseModel();
                packagingEstimateResponseModel.setPackageId(nextLargestPackage.getPackageId());
                packagingEstimateResponseModel.setProductIds(productIds);
                trueResult.add(packagingEstimateResponseModel);
            }

            // decrease the total volume
            totalVol = totalVol - product.getLength() * product.getBreadth() * product.getHeight();
            totalVol = Math.ceil(totalVol);
        }

        return trueResult;
    }

    private Package getNextLargestUsedPackage(
            Product productToFit,
            List<PackagingEstimateResponseModel> PackagingEstimateResponseModels,
            Map<Long, Package> packageIdPackageMapping,
            Map<Long, Product> productIdProductMapping
    ) {
        for(PackagingEstimateResponseModel packagingEstimateResponseModel : PackagingEstimateResponseModels) {
            Package _package = packageIdPackageMapping.get(packagingEstimateResponseModel.getPackageId());
            double packageVolume = _package.getLength() * _package.getBreadth() * _package.getHeight();
            double usedVolume = 0;
            for (Long productId : packagingEstimateResponseModel.getProductIds()) {
                Product product = productIdProductMapping.get(productId);
                usedVolume += product.getLength() * product.getBreadth() * product.getHeight();
            }

            double remainingVolume = packageVolume - usedVolume;
            double productVolume = productToFit.getLength() * productToFit.getBreadth() * productToFit.getHeight();
            if (remainingVolume > productVolume) {
                packagingEstimateResponseModel.getProductIds().add(productToFit.getProductId());
                return _package;
            }
        }

        return null;
    }

    private Package getNextLargestPackage(
            List<Package> packages,
            double totalVol
    ) throws Exception {
        Package nextLargestPackage = null;

        // Look for the next largest package greater than totalVol
        for (Package currentPackage : packages) {
            double packageVolume = currentPackage.getLength() * currentPackage.getBreadth() * currentPackage.getHeight();
            if (packageVolume > totalVol && currentPackage.getQuantity() > 0) {
                nextLargestPackage = currentPackage;
                break;
            }
        }

        // If no such package was found, look for the largest available package
        if (nextLargestPackage == null) {
            for (int i = packages.size() - 1; i >= 0; i--) {
                Package currentPackage = packages.get(i);
                if (currentPackage.getQuantity() > 0) {
                    nextLargestPackage = currentPackage;
                    break;
                }
            }
        }

        // If the package is still not found then all packages are over.
        if(nextLargestPackage == null) {
            throw new Exception("There are no more packages available to fit the products in");
        }
        return nextLargestPackage;
    }
    // </editor-fold>

    // <editor-fold desc="Make separate orders">
    public Response<List<OrderEstimateResponseModel>> getOrderEstimatesFromSalesOrderRequest(
            SalesOrderRequestModel salesOrderRequestModel,
            Map<Long, PickupLocation> productIdPickupLocationMappings,
            Map<Long, Product> productIdProductDetailsMappings,
            List<Package> packages,
            List<PackagingEstimateResponseModel> packagingEstimateResponseModels
            )
    {
        List<OrderEstimateResponseModel> result = new ArrayList<>();

        /* STEP 1: Create buckets with different pickup locations */
        Map<String, List<Long>> pickupLocationProductIdsMappings = new HashMap<>();
        Map<String, PickupLocation> pickupLocationIdPickupLocationDetailsMapping = new HashMap<>();
        for(Map.Entry<Long, PickupLocation> productIdPickupLocationMapping : productIdPickupLocationMappings.entrySet()) {
            if(pickupLocationProductIdsMappings.containsKey(productIdPickupLocationMapping.getValue().getAddressNickName())) {
                pickupLocationProductIdsMappings.get(productIdPickupLocationMapping.getValue().getAddressNickName()).add(productIdPickupLocationMapping.getKey());
            }
            else {
                pickupLocationProductIdsMappings.put(productIdPickupLocationMapping.getValue().getAddressNickName(), new ArrayList<>());
                pickupLocationProductIdsMappings.get(productIdPickupLocationMapping.getValue().getAddressNickName()).add(productIdPickupLocationMapping.getKey());
            }

            pickupLocationIdPickupLocationDetailsMapping.putIfAbsent(productIdPickupLocationMapping.getValue().getAddressNickName(), productIdPickupLocationMapping.getValue());
        }

        /* STEP 2: For each pickup location check how many boxes are being used. */
        int subOrderId = 1;
        for(Map.Entry<String, List<Long>> pickupLocationProductIdsMapping : pickupLocationProductIdsMappings.entrySet()) {
            try {
                for(PackagingEstimateResponseModel packagingEstimateResponseModel :
                        packagingEstimateResponseModels.stream()
                                .filter(packageEstimate -> Objects.equals(packageEstimate.getPickupLocationResponseModel().getPickupLocation().getAddressNickName(), pickupLocationProductIdsMapping.getKey()))
                                .toList()
                ) {
                    OrderEstimateResponseModel orderEstimateResponseModel = new OrderEstimateResponseModel();

                    // prepare the data
                    Map<Long, Integer> productIdQuantityMapping = salesOrderRequestModel.getSalesOrdersProductQuantityMaps().stream()
                            .filter(p -> packagingEstimateResponseModel.getProductIds().contains(p.getProductId()))
                            .collect(Collectors.toMap(
                                    SalesOrdersProductQuantityMap::getProductId,
                                    SalesOrdersProductQuantityMap::getQuantity
                            ));
                    Map<Long, Double> productIdPriceMapping = salesOrderRequestModel.getSalesOrdersProductQuantityMaps().stream()
                            .filter(p -> packagingEstimateResponseModel.getProductIds().contains(p.getProductId()))
                            .collect(Collectors.toMap(
                                    SalesOrdersProductQuantityMap::getProductId,
                                    SalesOrdersProductQuantityMap::getPricePerQuantityPerProduct
                            ));

                    // set the package
                    Optional<Package> matchingPackage = packages.stream()
                            .filter(p -> p.getPackageId() == packagingEstimateResponseModel.getPackageId())
                            .findFirst();
                    matchingPackage.ifPresent(orderEstimateResponseModel::set_package);

                    // set the products
                    orderEstimateResponseModel.setProducts(packagingEstimateResponseModel.getProductIds().stream().distinct()
                            .map(productIdProductDetailsMappings::get)
                            .toList());

                    // set the pickup location
                    orderEstimateResponseModel.setPickupLocation(pickupLocationIdPickupLocationDetailsMapping.get(pickupLocationProductIdsMapping.getKey()));

                    // set the billing address
                    orderEstimateResponseModel.setBillingAddress(salesOrderRequestModel.getBillingAddress());

                    // set the shipping address
                    orderEstimateResponseModel.setShippingAddress(salesOrderRequestModel.getShippingAddress());

                    // is opted for insurance
                    orderEstimateResponseModel.setOptedForInsurance(salesOrderRequestModel.getSalesOrder().isOptedForInsurance());

                    // set the payment details
                    orderEstimateResponseModel.setPaymentInfo(salesOrderRequestModel.getPaymentInfo());

                    // set the order id
                    orderEstimateResponseModel.setOrderId(salesOrderRequestModel.getSalesOrder().getSalesOrderId() + "-" + subOrderId++);
                    orderEstimateResponseModel.setSystemOrderId(salesOrderRequestModel.getSalesOrder().getPurchaseOrderId());

                    // set the order date
                    Date orderDate = DateHelper.getCurrentUTCDate();
                    orderEstimateResponseModel.setOrderDate(orderDate);

                    // set the productId quantity mapping
                    orderEstimateResponseModel.setProductIdQuantityMapping(productIdQuantityMapping);

                    // set the productId price mapping
                    orderEstimateResponseModel.setProductIdPriceMapping(productIdPriceMapping);

                    result.add(orderEstimateResponseModel);
                }
            }
            catch (Exception ex) {
                return new Response<>(false, ex.getMessage(), null);
            }
        }

        return new Response<>(true, "Success", result);
    }

    private List<Map<String, Object>> getShipRocketRequest(List<OrderEstimateResponseModel> orderEstimateResponseModels) {
        List<Map<String, Object>> result = new ArrayList<>();
        for(OrderEstimateResponseModel orderEstimateResponseModel : orderEstimateResponseModels) {
            HashMap<String, Object> jsonBody = new HashMap<>();

            // Order information
            jsonBody.put("order_id", orderEstimateResponseModel.getOrderId());
            jsonBody.put("order_date", orderEstimateResponseModel.getOrderDate().toString());
            jsonBody.put("pickup_location_id", orderEstimateResponseModel.getPickupLocation().getPickupLocationId());
            jsonBody.put("pickup_location_shipRocketId", orderEstimateResponseModel.getPickupLocation().getShipRocketPickupLocationId());

            // Billing address
            String[] namePartsForBilling = orderEstimateResponseModel.getBillingAddress().getNameOnAddress().split(" ");
            if (namePartsForBilling.length == 1) {
                // If there's only one part, set both first and last names to the same value
                jsonBody.put("billing_customer_name", namePartsForBilling[0]);
                jsonBody.put("billing_last_name", namePartsForBilling[0]);
            } else {
                // Otherwise, set the names as usual
                jsonBody.put("billing_customer_name", StringUtils.join(namePartsForBilling, " ", 0, namePartsForBilling.length - 1));
                jsonBody.put("billing_last_name", namePartsForBilling[namePartsForBilling.length - 1]);
            }

            jsonBody.put("billing_address", orderEstimateResponseModel.getBillingAddress().getLine1());
            jsonBody.put("billing_address_2", orderEstimateResponseModel.getBillingAddress().getLine2());
            jsonBody.put("billing_city", orderEstimateResponseModel.getBillingAddress().getCity());
            jsonBody.put("billing_pincode", orderEstimateResponseModel.getBillingAddress().getZipCode());
            jsonBody.put("billing_state", orderEstimateResponseModel.getBillingAddress().getState());
            jsonBody.put("billing_country", "India");
            jsonBody.put("billing_email", orderEstimateResponseModel.getBillingAddress().getEmailAtAddress());
            jsonBody.put("billing_phone", orderEstimateResponseModel.getBillingAddress().getPhoneOnAddress());

            // Shipping address
            String[] namePartsForShipping = orderEstimateResponseModel.getShippingAddress().getNameOnAddress().split(" ");
            if (namePartsForShipping.length == 1) {
                // If there's only one part, set both first and last names to the same value
                jsonBody.put("shipping_customer_name", namePartsForShipping[0]);
                jsonBody.put("shipping_last_name", namePartsForShipping[0]);
            } else {
                // Otherwise, set the names as usual
                jsonBody.put("shipping_customer_name", StringUtils.join(namePartsForShipping, " ", 0, namePartsForShipping.length - 1));
                jsonBody.put("shipping_last_name", namePartsForShipping[namePartsForShipping.length - 1]);
            }

            jsonBody.put("shipping_is_billing", false);
            jsonBody.put("shipping_address", orderEstimateResponseModel.getShippingAddress().getLine1());
            jsonBody.put("shipping_address_2", orderEstimateResponseModel.getShippingAddress().getLine2());
            jsonBody.put("shipping_city", orderEstimateResponseModel.getShippingAddress().getCity());
            jsonBody.put("shipping_pincode", orderEstimateResponseModel.getShippingAddress().getZipCode());
            jsonBody.put("shipping_state", orderEstimateResponseModel.getShippingAddress().getState());
            jsonBody.put("shipping_country", "India");
            jsonBody.put("shipping_email", orderEstimateResponseModel.getShippingAddress().getEmailAtAddress());
            jsonBody.put("shipping_phone", orderEstimateResponseModel.getShippingAddress().getPhoneOnAddress());

            // Order items
            List<Map<String, Object>> orderItems = orderEstimateResponseModel.getProducts().stream()
                    .map(product -> {
                        HashMap<String, Object> item = new HashMap<>();
                        item.put("name", product.getTitle());
                        item.put("sku", product.getUpc());
                        item.put("units", orderEstimateResponseModel.getProductIdQuantityMapping().get(product.getProductId()));
                        item.put("selling_price", orderEstimateResponseModel.getProductIdPriceMapping().get(product.getProductId()) + orderEstimateResponseModel.getProductIdPriceMapping().get(product.getProductId()) * 0.18);
                        item.put("discount", product.getPrice() - orderEstimateResponseModel.getProductIdPriceMapping().get(product.getProductId()));
                        item.put("tax", orderEstimateResponseModel.getProductIdPriceMapping().get(product.getProductId()) * 0.18);
                        return item;
                    })
                    .collect(Collectors.toList());
            jsonBody.put("order_items", orderItems);

            // Payment and pricing information
            jsonBody.put("payment_method", PaymentHelper.getPaymentMode(orderEstimateResponseModel.getPaymentInfo().getMode()) == PaymentHelper.PaymentMode.COD ? "COD" : "Prepaid");
            jsonBody.put("sub_total", orderEstimateResponseModel.getPaymentInfo().getTotal());

            // Dimensions and weight
            jsonBody.put("length", orderEstimateResponseModel.get_package().getLength());
            jsonBody.put("breadth", orderEstimateResponseModel.get_package().getBreadth());
            jsonBody.put("height", orderEstimateResponseModel.get_package().getHeight());
            jsonBody.put("weight", orderEstimateResponseModel.getProducts().stream()
                    .mapToDouble(product -> {
                        Double weightKgs = product.getWeightKgs();
                        Integer quantity = orderEstimateResponseModel.getProductIdQuantityMapping().get(product.getProductId());
                        if (weightKgs != null && quantity != null) {
                            return weightKgs * quantity;
                        } else {
                            return 0.0;
                        }
                    })
                    .sum());

            result.add(jsonBody);
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold desc="Helper functions">
    public Pair<String, Boolean> checkIfOrderCanBeUpdated(ShippingHelper shippingHelper,
                                                          List<SalesOrderPackagingAndShipRocketMapping> salesOrderPackagingAndShipRocketMappings,
                                                          String shipRocketToken) {
        // get tracking status
        for(SalesOrderPackagingAndShipRocketMapping salesOrderPackagingAndShipRocketMapping : salesOrderPackagingAndShipRocketMappings) {
            Response<GetTrackingThroughAWBResponseModel> getTrackingThroughAWBResponse = shippingHelper.trackShipmentThroughAWB(shipRocketToken, salesOrderPackagingAndShipRocketMapping.getShipRocketGeneratedAWB());
            if(!getTrackingThroughAWBResponse.isSuccess()) {
                return Pair.of(getTrackingThroughAWBResponse.getMessage(), false);
            }

            List<GetTrackingThroughAWBResponseModel.ShipmentTrackActivity> shipmentTrackActivities = getTrackingThroughAWBResponse.getItem().getTracking_data().getShipment_track_activities()
                    .stream()
                    .filter(shipmentTrackActivity -> shipmentTrackActivity.getActivity().equalsIgnoreCase("out for pickup"))
                    .toList();
            if(!shipmentTrackActivities.isEmpty()) {
                return Pair.of(salesOrderPackagingAndShipRocketMapping.getShipRocketGeneratedAWB() + " cannot be cancelled hence the sales order cannot be cancelled", false);
            }
        }

        return Pair.of("Success", true);
    }
    // </editor-fold>

    // <editor-fold desc="Shiprocket API">
    public Response<String> getToken() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(_apiUrl + "/auth/login");

            HashMap<String, Object> jsonBody = new HashMap<>();
            jsonBody.put("email", _email);
            jsonBody.put("password", _password);

            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(jsonBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(data, StandardCharsets.UTF_8))
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return new Response<>(false, "Error in getting the auth token from Shiprocket API.", null);
            }

            TokenResponseModel tokenResponse = mapper.readValue(response.body(), TokenResponseModel.class);
            return new Response<>(true, "Successfully got token", tokenResponse.getToken());
        }
        catch (Exception e) {
            return new Response<>(false, "Exception occurred: " + e, null);
        }
    }

    public Response<AddPickupLocationResponseModel> addPickupLocation(
            String token,
            PickupLocationRequestModel pickupLocationRequestModel
    ) {
        HashMap<String, Object> jsonBody = new HashMap<>();

        String pickupLocationName = pickupLocationRequestModel.getPickupLocation().getAddressNickName();
        if(pickupLocationRequestModel.isEdit()){
            pickupLocationName = pickupLocationName + DateHelper.getCurrentUTCDateTime();
        }
        jsonBody.put("pickup_location", pickupLocationName);
        jsonBody.put("name", pickupLocationRequestModel.getAddress().getNameOnAddress());
        jsonBody.put("email", pickupLocationRequestModel.getAddress().getEmailAtAddress());
        jsonBody.put("phone", pickupLocationRequestModel.getAddress().getPhoneOnAddress());
        jsonBody.put("address", pickupLocationRequestModel.getAddress().getLine1());
        jsonBody.put("address_2", pickupLocationRequestModel.getAddress().getLine2());
        jsonBody.put("city", pickupLocationRequestModel.getAddress().getCity());
        jsonBody.put("state", pickupLocationRequestModel.getAddress().getState());
        jsonBody.put("country", "India");
        jsonBody.put("pin_code", pickupLocationRequestModel.getAddress().getZipCode());

        return httpResponse(token,
                _apiUrl + "/settings/company/addpickup",
                "POST",
                new TypeToken<AddPickupLocationResponseModel>(){}.getType(),
                jsonBody,
                "Successfully added pickup location.");
    }

    public Response<GetAllPickupLocationsResponseModel> getAllPickupLocations(
            String token
    ) {
        return httpResponse(token,
                _apiUrl + "/settings/company/pickup",
                "GET",
                new TypeToken<GetAllPickupLocationsResponseModel>(){}.getType(),
                null,
                "Successfully got all pickup locations.");
    }

    public Response<UpdatePickupLocationResponseModel> updatePickupLocationForShipRocketOrder(String token,
                                                                    List<Long> shipRocketOrderId,
                                                                    long shipRocketPickupLocationId) {
        Response<GetAllPickupLocationsResponseModel> getAllPickupLocationsResponseModelResponse = getAllPickupLocations(token);
        if(!getAllPickupLocationsResponseModelResponse.isSuccess() ||
                getAllPickupLocationsResponseModelResponse.getItem().getData().getShipping_address() == null ||
                getAllPickupLocationsResponseModelResponse.getItem().getData().getShipping_address().isEmpty()) {
            return new Response<>(false, getAllPickupLocationsResponseModelResponse.getMessage(), null);
        }

        String pickupLocationNameOnShipRocket = getAllPickupLocationsResponseModelResponse.getItem().getData().getShipping_address()
                .stream()
                .filter(shippingAddress -> shippingAddress.getId() == shipRocketPickupLocationId)
                .findFirst()
                .map(map -> map.pickup_location)
                .orElse(null);

        HashMap<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("order_id", shipRocketOrderId);
        jsonBody.put("pickup_location", pickupLocationNameOnShipRocket);

        if(pickupLocationNameOnShipRocket != null){
            return httpResponse(token,
                    _apiUrl + "/orders/address/pickup",
                    "PATCH",
                    new TypeToken<UpdatePickupLocationResponseModel>(){}.getType(),
                    jsonBody,
                    "Successfully updated pickup location for the given shiprocket order.");
        }
        else {
            return new Response<>(false, "Invalid pickup location provider", null);
        }
    }

    public Response<ShippingOptionsResponseModel> getAvailableShippingOptions(
            String token,
            String pickupZipCode,
            String deliveryZipCode,
            boolean isOrderPrePaid,
            String weightOfOrderInKgs
    ) {
        HashMap<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("pickup_postcode", pickupZipCode);
        jsonBody.put("delivery_postcode", deliveryZipCode);
        jsonBody.put("cod", isOrderPrePaid);
        jsonBody.put("weight", weightOfOrderInKgs);

        return httpResponse(token,
                _apiUrl + "/courier/serviceability",
                "GET",
                new TypeToken<ShippingOptionsResponseModel>(){}.getType(),
                jsonBody,
                "Successfully got the available shipping options.");
    }

    public Response<List<PlaceOrderResponseModel>> createShippingForSalesOrderOrder(
            String token,
            long salesOrderId,
            List<OrderEstimateResponseModel> orderEstimateResponseModels) {

        List<PlaceOrderResponseModel> placeOrderResponseModels = new ArrayList<>();
        List<Map<String, Object>> jsonBodys = getShipRocketRequest(orderEstimateResponseModels);

        Response<GetAllPickupLocationsResponseModel> getAllPickupLocationsResponseModelResponse = getAllPickupLocations(token);
        if(!getAllPickupLocationsResponseModelResponse.isSuccess() ||
                getAllPickupLocationsResponseModelResponse.getItem().getData().getShipping_address() == null ||
                getAllPickupLocationsResponseModelResponse.getItem().getData().getShipping_address().isEmpty()) {
            return new Response<>(false, getAllPickupLocationsResponseModelResponse.getMessage(), null);
        }

        for(Map<String, Object> jsonBody : jsonBodys) {
            long pickupLocationId = (long)jsonBody.get("pickup_location_id");
            long shipRocketPickupLocationId = (long)jsonBody.get("pickup_location_shipRocketId");

            jsonBody.remove("pickup_location_id");
            jsonBody.remove("pickup_location_shipRocketId");

            String pickupLocationNameOnShipRocket = getAllPickupLocationsResponseModelResponse.getItem().getData().getShipping_address()
                    .stream()
                    .filter(shippingAddress -> shippingAddress.getId() == shipRocketPickupLocationId)
                    .findFirst()
                    .map(map -> map.pickup_location)
                    .orElse(null);
            if (pickupLocationNameOnShipRocket == null) {
                return new Response<>(false, "Error fetching in pickup location name from shiprocket", null);
            }

            jsonBody.put("pickup_location", pickupLocationNameOnShipRocket);
            Response<PlaceOrderResponseModel> placeOrderResponseModelResponse = httpResponse(token,
                    _apiUrl + "/orders/create/adhoc",
                    "POST",
                    new TypeToken<PlaceOrderResponseModel>(){}.getType(),
                    jsonBody,
                    "Successfully created an order on Shiprocket.");

            if(!placeOrderResponseModelResponse.isSuccess()) {
                return new Response<>(false, placeOrderResponseModelResponse.getMessage(), null);
            }
            else{
                placeOrderResponseModelResponse.getItem().setPickupLocationId(pickupLocationId);
                placeOrderResponseModelResponse.getItem().setSystemOrderId(salesOrderId);
                placeOrderResponseModels.add(placeOrderResponseModelResponse.getItem());
            }
        }

        return new Response<>(true, "Successfully placed ship rocket order", placeOrderResponseModels);
    }

    public Response<List<GenerateAWBResponseModel>> generateAWBForShipment(
            String token,
            List<Long> shipmentIds,
            Map<Long, String> shipmentIdCourierIdMapping,
            long orderId
    ) {
        List<GenerateAWBResponseModel> result = new ArrayList<>();
        for(Long shipmentId : shipmentIds) {
            HashMap<String, Object> jsonBody = new HashMap<>();
            jsonBody.put("shipment_id", shipmentId);
            jsonBody.put("courier_id", shipmentIdCourierIdMapping.get(shipmentId));

            Response<GenerateAWBResponseModel> generateAWBResponseModelResponse =  httpResponse(token,
                    _apiUrl + "/courier/assign/awb",
                    "POST",
                    new TypeToken<GenerateAWBResponseModel>(){}.getType(),
                    jsonBody,
                    "Successfully assigned awb.");
            if(generateAWBResponseModelResponse.isSuccess()) {
                generateAWBResponseModelResponse.getItem().setSystemOrderId(orderId);
                result.add(generateAWBResponseModelResponse.getItem());
            }
            else{
                return new Response<>(false, generateAWBResponseModelResponse.getMessage(), result);
            }
        }
        return new Response<>(true, "Successfully assigned awbs.", result);
    }

    public Response<List<ShipmentPickupResponseModel>> requestForShipmentPickupRequest(
            String token,
            List<Long> shipmentIds,
            Map<Long, Date> shipmentIdPickupDateMapping,
            long orderId
    ) {
        List<ShipmentPickupResponseModel> result = new ArrayList<>();
        for(Long shipmentId : shipmentIds) {
            HashMap<String, Object> jsonBody = new HashMap<>();
            jsonBody.put("shipment_id", shipmentId);
            jsonBody.put("pickup_date", new SimpleDateFormat("yyyy-mm-dd").format(shipmentIdPickupDateMapping.get(shipmentId)));

            Response<ShipmentPickupResponseModel> shipmentPickupResponseModelResponse = httpResponse(token,
                    _apiUrl + "/courier/generate/pickup",
                    "POST",
                    new TypeToken<ShipmentPickupResponseModel>(){}.getType(),
                    jsonBody,
                    "Successfully generated pickup.");

            if(shipmentPickupResponseModelResponse.isSuccess()) {
                shipmentPickupResponseModelResponse.getItem().setSystemOrderId(orderId);
                result.add(shipmentPickupResponseModelResponse.getItem());
            }
        }

        return new Response<>(true, "Successfully generated pickups for shipments.", result);
    }

    public Response<Boolean> updateCustomerDeliveryAddress(String token, long shipRocketOrderId, Address address) {
        HashMap<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("order_id", shipRocketOrderId);
        jsonBody.put("shipping_customer_name", address.getNameOnAddress());
        jsonBody.put("shipping_phone", address.getPhoneOnAddress());
        jsonBody.put("shipping_address", address.getLine1());
        jsonBody.put("shipping_address_2", address.getLine2() + ", " + address.getLandmark());
        jsonBody.put("shipping_city", address.getCity());
        jsonBody.put("shipping_state", address.getState());
        jsonBody.put("shipping_country", "India");
        jsonBody.put("shipping_pincode", address.getZipCode());

        return httpResponse(token,
                _apiUrl + "/orders/address/update",
                "POST",
                new TypeToken<Boolean>(){}.getType(),
                jsonBody,
                "Successfully updated shipping address for order.");
    }

    public Response<CancelShipmentResponseModel> cancelShipment(String token, List<String> awbs) {
        HashMap<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("awbs", awbs);

        return httpResponse(token,
                _apiUrl + "/orders/cancel/shipment/awbs",
                "POST",
                new TypeToken<CancelShipmentResponseModel>(){}.getType(),
                jsonBody,
                "Successfully cancelled pickup.");
    }

    public Response<GetTrackingThroughAWBResponseModel> trackShipmentThroughAWB(String token, String awb) {
        return httpResponse(token,
                _apiUrl + "/courier/track/awb/" + awb,
                "GET",
                new TypeToken<GetTrackingThroughAWBResponseModel>(){}.getType(),
                null,
                "Successfully got tracking information for AWB.");
    }

    public Response<GenerateManifestResponseModel> generateManifest(String token, List<Long> shipmentIds) {
        HashMap<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("shipment_id", shipmentIds);

        Response<GenerateManifestResponseModel> generateManifestResponse = httpResponse(token,
                _apiUrl + "/manifests/generate",
                "POST",
                new TypeToken<GenerateManifestResponseModel>(){}.getType(),
                jsonBody,
                "Successfully generated manifest for given shipmentIds.");

        if(generateManifestResponse.getItem() != null &&
                generateManifestResponse.getItem().getMessage() != null &&
                org.springframework.util.StringUtils.hasText(generateManifestResponse.getItem().getMessage())) {
            return new Response<>(false, generateManifestResponse.getItem().getMessage(), null);
        }

        return generateManifestResponse;
    }

    public Response<PrintManifestResponseModel> generatePrintManifest(String token, List<Long> shipRocketOrderIds) {
        HashMap<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("order_ids", shipRocketOrderIds);

        Response<PrintManifestResponseModel> printManifestResponse= httpResponse(token,
                _apiUrl + "/manifests/print",
                "POST",
                new TypeToken<PrintManifestResponseModel>(){}.getType(),
                jsonBody,
                "Successfully generated print version of manifests for the given order Ids.");

        if(printManifestResponse.getItem() != null &&
                printManifestResponse.getItem().getMessage() != null &&
            org.springframework.util.StringUtils.hasText(printManifestResponse.getItem().getMessage())) {
            return new Response<>(false, printManifestResponse.getItem().getMessage(), null);
        }

        return printManifestResponse;
    }

    public Response<GenerateLabelResponseModel> generateLabel(String token, List<Long> shipmentIds) {
        HashMap<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("shipment_id", shipmentIds);

        Response<GenerateLabelResponseModel> generateLabelResponse = httpResponse(token,
                _apiUrl + "/courier/generate/label",
                "POST",
                new TypeToken<GenerateLabelResponseModel>(){}.getType(),
                jsonBody,
                "Successfully generated label for the given shipmentIds.");

        if(generateLabelResponse.getItem() != null &&
                generateLabelResponse.getItem().getLabel_created() != 1) {
            if(generateLabelResponse.getItem().getMessage() != null &&
                    org.springframework.util.StringUtils.hasText(generateLabelResponse.getItem().getMessage())) {
                return new Response<>(false, generateLabelResponse.getItem().getMessage(), null);
            }
            else if(generateLabelResponse.getItem().getResponse() != null &&
                    org.springframework.util.StringUtils.hasText(generateLabelResponse.getItem().getResponse())){
                return new Response<>(false, generateLabelResponse.getItem().getResponse(), null);
            }
        }

        return generateLabelResponse;
    }

    public Response<GenerateInvoiceResponseModel> generateInvoice(String token, List<Long> shipRocketOrderIds) {
        HashMap<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("ids", shipRocketOrderIds);
        Response<GenerateInvoiceResponseModel> generateInvoiceResponse = httpResponse(token,
                _apiUrl + "/orders/print/invoice",
                "POST",
                new TypeToken<GenerateInvoiceResponseModel>(){}.getType(),
                jsonBody,
                "Successfully generated invoice for the given shipRocket order ids.");
        if(generateInvoiceResponse.getItem() != null &&
                !generateInvoiceResponse.getItem().is_invoice_created() &&
                generateInvoiceResponse.getItem().getMessage() != null &&
                org.springframework.util.StringUtils.hasText(generateInvoiceResponse.getItem().getMessage())){
            return new Response<>(false, generateInvoiceResponse.getItem().getMessage(), null);
        }
        else{
            return generateInvoiceResponse;
        }
    }
    //</editor-fold>
}