package org.example.Translators.CentralDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CentralModels.Carrier;
import org.example.Models.CommunicationModels.CentralModels.WebTemplateCarrierMapping;
import org.example.Models.RequestModels.GridRequestModels.GetCarriersRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.CarrierByWebTemplateWildCardResponse;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CentralDatabaseTranslators.Interfaces.ICarrierSubTranslator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CarrierSubTranslator extends Translator implements ICarrierSubTranslator {

    public CarrierSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<Carrier> getCarrierDetailsById(long carrierId) {
        Map<String, Object> params = new HashMap<>();
        params.put("CarrierId", carrierId);
        params.put("carrierId", carrierId);

        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.CARRIER + "/" + ApiRoutes.CarriersSubRoute.GET_CARRIER_DETAILS_BY_ID,
                        params),
                "GET",
                new TypeToken<Response<Carrier>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> isUserMappedToCarrier() {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.CARRIER + "/" + ApiRoutes.CarriersSubRoute.IS_USER_MAPPED_TO_CARRIER),
                "GET",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<PaginationBaseResponseModel<Carrier>> getCarriersInBatches(GetCarriersRequestModel getCarriersRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.CARRIER + "/" + ApiRoutes.CarriersSubRoute.GET_CARRIER_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<Carrier>>>(){}.getType(),
                getCarriersRequestModel);
    }

    @Override
    public Response<Boolean> updateApiKeys(Carrier carrier) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.CARRIER + "/" + ApiRoutes.CarriersSubRoute.UPDATE_API_KEYS),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                carrier);
    }

    @Override
    public Response<Carrier> getApiKeys() {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.CARRIER + "/" + ApiRoutes.CarriersSubRoute.GET_API_KEYS),
                "GET",
                new TypeToken<Response<Carrier>>(){}.getType(),
                null);
    }

    @Override
    public Response<CarrierByWebTemplateWildCardResponse> getCarrierByWebTemplateWildCard(String wildCard) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.CARRIER + "/" + ApiRoutes.CarriersSubRoute.GET_CARRIER_ID_BY_WEB_TEMPLATE_WILDCARD,
                Collections.singletonMap("wildCard", wildCard)),
                "GET",
                new TypeToken<Response<CarrierByWebTemplateWildCardResponse>>(){}.getType(),
                null);
    }

    @Override
    public Response<String> getTokenForWebTemplate(WebTemplateCarrierMapping webTemplateCarrierMapping) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.CARRIER + "/" + ApiRoutes.CarriersSubRoute.GET_TOKEN_FOR_WEBTEMPLATE),
                "POST",
                new TypeToken<Response<String>>(){}.getType(),
                webTemplateCarrierMapping);
    }
}