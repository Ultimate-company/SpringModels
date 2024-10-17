package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.RequestModels.ApiRequestModels.LeadRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.LeadResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.ILeadSubTranslator;

import java.util.Collections;

public class LeadSubTranslator extends Translator implements ILeadSubTranslator {
    public LeadSubTranslator(String token, Long auditUserId, Long carrierId) {
        super(token, auditUserId, carrierId);
    }

    @Override
    public Response<PaginationBaseResponseModel<LeadResponseModel>> getLeadsInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LEAD + "/" + ApiRoutes.LeadsSubRoute.GET_LEADS_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<LeadResponseModel>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<Boolean> toggleLead(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LEAD + "/" + ApiRoutes.LeadsSubRoute.TOGGLE_LEAD,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<LeadResponseModel> getLeadDetailsByEmail(String email) {
        return null;
    }

    @Override
    public Response<Long> createLead(LeadRequestModel leadRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LEAD + "/" + ApiRoutes.LeadsSubRoute.CREATE_LEAD),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                leadRequestModel);
    }

    @Override
    public Response<Long> updateLead(LeadRequestModel leadRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LEAD + "/" + ApiRoutes.LeadsSubRoute.UPDATE_LEAD),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                leadRequestModel);
    }

    @Override
    public Response<LeadResponseModel> getLeadDetailsById(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.LEAD + "/" + ApiRoutes.LeadsSubRoute.GET_LEAD_DETAILS_BY_ID,
                        Collections.singletonMap("id", id)),
                "GET",
                new TypeToken<Response<LeadResponseModel>>(){}.getType(),
                null);
    }
}