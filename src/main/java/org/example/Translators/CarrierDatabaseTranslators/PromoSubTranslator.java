package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.Promo;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IPromoSubTranslator;

import java.util.Collections;

public class PromoSubTranslator extends Translator implements IPromoSubTranslator {
    public PromoSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<PaginationBaseResponseModel<Promo>> getPromosInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PROMO + "/" + ApiRoutes.PromosSubRoute.GET_PROMOS_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<Promo>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<Long> createPromo(Promo promo) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PROMO + "/" + ApiRoutes.PromosSubRoute.CREATE_PROMO),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                promo);
    }

    @Override
    public Response<Promo> getPromoDetailsById(long promoId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PROMO + "/" + ApiRoutes.PromosSubRoute.GET_PROMO_DETAILS_BY_ID,
                        Collections.singletonMap("id", promoId)),
                "GET",
                new TypeToken<Response<Promo>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> togglePromo(long promoId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PROMO + "/" + ApiRoutes.PromosSubRoute.TOGGLE_PROMO,
                        Collections.singletonMap("id", promoId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Promo> getPromoDetailsByName(String promoCode) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PROMO + "/" + ApiRoutes.PromosSubRoute.GET_PROMO_DETAILS_BY_NAME,
                        Collections.singletonMap("promoCode", promoCode)),
                "GET",
                new TypeToken<Response<Promo>>(){}.getType(),
                null);
    }
}