package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.RequestModels.ApiRequestModels.PurchaseOrderRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.PurchaseOrderResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IPurchaseOrderSubTranslator;

import java.util.Collections;

public class PurchaseOrderSubTranslator extends Translator implements IPurchaseOrderSubTranslator {
    public PurchaseOrderSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<PaginationBaseResponseModel<PurchaseOrderResponseModel>> getPurchaseOrdersInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PURCHASE_ORDER + "/" + ApiRoutes.PurchaseOrderSubRoute.GET_PURCHASE_ORDERS_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<PurchaseOrderResponseModel>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<Long> createPurchaseOrder(PurchaseOrderRequestModel purchaseOrderRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PURCHASE_ORDER + "/" + ApiRoutes.PurchaseOrderSubRoute.CREATE_PURCHASE_ORDER),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                purchaseOrderRequestModel);
    }

    @Override
    public Response<Long> updatePurchaseOrder(PurchaseOrderRequestModel purchaseOrderRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PURCHASE_ORDER + "/" + ApiRoutes.PurchaseOrderSubRoute.UPDATE_PURCHASE_ORDER),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                purchaseOrderRequestModel);
    }

    @Override
    public Response<PurchaseOrderResponseModel> getPurchaseOrderDetailsById(long purchaseOrderId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PURCHASE_ORDER + "/" + ApiRoutes.PurchaseOrderSubRoute.GET_PURCHASE_ORDER_BY_ID,
                        Collections.singletonMap("id", purchaseOrderId)),
                "GET",
                new TypeToken<Response<PurchaseOrderResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> togglePurchaseOrder(long purchaseOrderId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PURCHASE_ORDER + "/" + ApiRoutes.PurchaseOrderSubRoute.TOGGLE_PURCHASE_ORDER,
                        Collections.singletonMap("id", purchaseOrderId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> approvedByPurchaseOrder(long purchaseOrderId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PURCHASE_ORDER + "/" + ApiRoutes.PurchaseOrderSubRoute.APPROVED_BY_PURCHASE_ORDER,
                        Collections.singletonMap("id", purchaseOrderId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<String> getPurchaseOrderPDF(long purchaseOrderId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PURCHASE_ORDER + "/" + ApiRoutes.PurchaseOrderSubRoute.GET_PURCHASE_ORDER_PDF,
                        Collections.singletonMap("id", purchaseOrderId)),
                "GET",
                new TypeToken<Response<String>>(){}.getType(),
                null);
    }
}
