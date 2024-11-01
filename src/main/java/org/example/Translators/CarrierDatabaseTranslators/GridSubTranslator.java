package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.UserGridPreference;
import org.example.Models.RequestModels.ApiRequestModels.GridPreferenceRequestModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IGridSubTranslator;

import java.util.Collections;

public class GridSubTranslator extends Translator implements IGridSubTranslator {
    public GridSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<Boolean> updateGridVisibilityPreference(GridPreferenceRequestModel gridPreferenceRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.GRID + "/" + ApiRoutes.GridSubRoute.UPDATE_GRID_VISIBILITY_PREFERENCE),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                gridPreferenceRequestModel);
    }

    @Override
    public Response<Boolean> updateGridDensityVisibilityPreference(GridPreferenceRequestModel gridPreferenceRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.GRID + "/" + ApiRoutes.GridSubRoute.UPDATE_GRID_DENSITY_PREFERENCE),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                gridPreferenceRequestModel);
    }

    @Override
    public Response<Boolean> updateRowsPerPagePreference(GridPreferenceRequestModel gridPreferenceRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.GRID + "/" + ApiRoutes.GridSubRoute.UPDATE_ROWS_PER_PAGE_PREFERENCE),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                gridPreferenceRequestModel);
    }

    @Override
    public Response<UserGridPreference> getGridVisibilityPreference(int gridId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.GRID + "/" + ApiRoutes.GridSubRoute.GET_GRID_VISIBILITY_PREFERENCE,
                        Collections.singletonMap("gridId", gridId)),
                "GET",
                new TypeToken<Response<UserGridPreference>>(){}.getType(),
                null);
    }
}