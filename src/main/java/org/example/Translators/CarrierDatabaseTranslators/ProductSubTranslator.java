package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.Product;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.ProductsResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IProductSubTranslator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSubTranslator extends Translator implements IProductSubTranslator {
    public ProductSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }
    public ProductSubTranslator(String token, String wildCard, long webTemplateId, long carrierId, Long userId, String apiUrl) {
        super(token, wildCard, webTemplateId, carrierId, userId, apiUrl);
    }

    @Override
    public Response<Long> addProduct(Product product) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.ADD_PRODUCT),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                product);
    }

    @Override
    public Response<Long> editProduct(Product product) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.EDIT_PRODUCT),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                product);
    }

    @Override
    public Response<Boolean> toggleDeleteProduct(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.TOGGLE_DELETE_PRODUCT,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> toggleReturnProduct(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.TOGGLE_RETURN_PRODUCT,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<ProductsResponseModel> getProductDetailsById(long productId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.GET_PRODUCT_DETAILS_BY_ID,
                        Collections.singletonMap("id", productId)),
                "GET",
                new TypeToken<Response<ProductsResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<PaginationBaseResponseModel<ProductsResponseModel>> getProductInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.GET_PRODUCTS_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<ProductsResponseModel>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<List<ProductsResponseModel>> getProductDetailsByIds(List<Long> productIds) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.GET_PRODUCT_DETAILS_BY_IDS,
                        Collections.singletonMap("id", productIds.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(",")))),
                "GET",
                new TypeToken<Response<List<ProductsResponseModel>>>(){}.getType(),
                null);
    }

    // Public endpoints
    @Override
    public Response<PaginationBaseResponseModel<ProductsResponseModel>> getProductInBatches_Public(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.GET_PRODUCTS_IN_BATCHES_PUBLIC),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<ProductsResponseModel>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<List<ProductsResponseModel>> getProductDetailsByIds_Public(List<Long> productIds) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.GET_PRODUCT_DETAILS_BY_IDS_PUBLIC,
                        Collections.singletonMap("id", productIds.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(",")))),
                "GET",
                new TypeToken<Response<List<ProductsResponseModel>>>(){}.getType(),
                null);
    }

    @Override
    public Response<ProductsResponseModel> getProductDetailsById_Public(long productId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT + "/" + ApiRoutes.ProductsSubRoute.GET_PRODUCT_DETAILS_BY_ID_PUBLIC,
                        Collections.singletonMap("id", productId)),
                "GET",
                new TypeToken<Response<ProductsResponseModel>>(){}.getType(),
                null);
    }
}