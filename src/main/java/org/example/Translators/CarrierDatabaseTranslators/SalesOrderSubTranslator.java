package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.RequestModels.ApiRequestModels.SalesOrderRequestModel;
import org.example.Models.RequestModels.GridRequestModels.GetSalesOrdersRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.SalesOrderResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.ISalesOrderSubTranslator;

import java.util.Collections;
import java.util.Map;

public class SalesOrderSubTranslator extends Translator implements ISalesOrderSubTranslator {
    public SalesOrderSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }
    @Override
    public Response<PaginationBaseResponseModel<SalesOrderResponseModel>> getSalesOrdersInBatches(GetSalesOrdersRequestModel getSalesOrdersRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.GET_SALES_ORDERS_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<SalesOrderResponseModel>>>(){}.getType(),
                getSalesOrdersRequestModel);
    }

    @Override
    public Response<Long> createSalesOrder(SalesOrderRequestModel salesOrderRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.CREATE_SALES_ORDER),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                salesOrderRequestModel);
    }

    @Override
    public Response<Long> updateSalesOrder(SalesOrderRequestModel salesOrderRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.UPDATE_SALES_ORDER),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                salesOrderRequestModel);
    }

    @Override
    public Response<SalesOrderResponseModel> getSalesOrderDetailsById(long salesOrderId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.GET_SALES_ORDER_BY_ID,
                        Collections.singletonMap("id", salesOrderId)),
                "GET",
                new TypeToken<Response<SalesOrderResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> toggleSalesOrder(long salesOrderId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.TOGGLE_SALES_ORDER,
                        Collections.singletonMap("id", salesOrderId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<byte[]> getSalesOrderPDF(long salesOrderId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.GET_SALES_ORDER_PDF,
                        Collections.singletonMap("id", salesOrderId)),
                "GET",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> cancelSalesOrder(long salesOrderId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.CANCEL_SALES_ORDER,
                        Collections.singletonMap("id", salesOrderId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> updateCustomerDeliveryAddress(long salesOrderId, Address address) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.UPDATE_CUSTOMER_DELIVERY_ADDRESS,
                        Collections.singletonMap("id", salesOrderId)),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                address);
    }

    @Override
    public Response<Boolean> updateSalesOrderPickupAddress(long salesOrderId, long shipRocketOrderId, long pickupLocationId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SALES_ORDER + "/" + ApiRoutes.SalesOrderSubRoute.UPDATE_SALES_ORDER_PICKUP_ADDRESS,
                Map.of(
                        "id", salesOrderId,
                        "shipRocketOrderId", shipRocketOrderId,
                        "pickupLocationId", pickupLocationId
                )),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }
}
