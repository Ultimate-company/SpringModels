package org.example.Translators.CarrierDatabaseTranslators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.Promo;
import org.example.Models.RequestModels.ApiRequestModels.WebTemplateRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.WebTemplateResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IPromoSubTranslator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IWebTemplateSubTranslator;

import java.util.Collections;

public class WebTemplateSubTranslator extends Translator implements IWebTemplateSubTranslator {

    public WebTemplateSubTranslator(String token, Long auditUserId, Long carrierId) {
        super(token, auditUserId, carrierId);
    }

    public WebTemplateSubTranslator(String token, String wildCard, Long webTemplateId, Long carrierId, Long userId) {
        super(token, wildCard, webTemplateId, carrierId, userId);
    }

    @Override
    public Response<WebTemplateResponseModel> getWebTemplateById(long webTemplateId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.WEB_TEMPLATE + "/" + ApiRoutes.WebTemplateSubRoute.GET_WEB_TEMPLATE_BY_ID,
                        Collections.singletonMap("id", webTemplateId)),
                "GET",
                new TypeToken<Response<WebTemplateResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<PaginationBaseResponseModel<WebTemplateResponseModel>> getWebTemplatesInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.WEB_TEMPLATE + "/" + ApiRoutes.WebTemplateSubRoute.GET_WEB_TEMPLATES_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<WebTemplateResponseModel>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<Long> insertWebTemplate(WebTemplateRequestModel webTemplateRequestModel) throws JsonProcessingException {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.WEB_TEMPLATE + "/" + ApiRoutes.WebTemplateSubRoute.INSERT_WEB_TEMPLATE),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                webTemplateRequestModel);
    }

    @Override
    public Response<Boolean> toggleWebTemplate(long webTemplateId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.WEB_TEMPLATE + "/" + ApiRoutes.WebTemplateSubRoute.TOGGLE_WEB_TEMPLATE,
                        Collections.singletonMap("id", webTemplateId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> deployWebTemplate(long webTemplateId) {
        return null;
    }

    @Override
    public Response<Long> updateWebTemplate(WebTemplateRequestModel webTemplateRequestModel) throws JsonProcessingException {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.WEB_TEMPLATE + "/" + ApiRoutes.WebTemplateSubRoute.UPDATE_WEB_TEMPLATE),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                webTemplateRequestModel);
    }

    @Override
    public Response<Long> updateUserCart(WebTemplateRequestModel webTemplateRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.WEB_TEMPLATE + "/" + ApiRoutes.WebTemplateSubRoute.UPDATE_USER_CART),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                webTemplateRequestModel);
    }

    @Override
    public Response<Long> updateUserLikedItems(WebTemplateRequestModel webTemplateRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.WEB_TEMPLATE + "/" + ApiRoutes.WebTemplateSubRoute.UPDATE_USER_LIKED_ITEMS),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                webTemplateRequestModel);
    }
}
