package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.PickupLocation;
import org.example.Models.RequestModels.ApiRequestModels.PickupLocationRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.PickupLocationResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IPickupLocationSubTranslator;

import java.util.Collections;
import java.util.List;

public class PickupLocationSubTranslator extends Translator implements IPickupLocationSubTranslator {
    public PickupLocationSubTranslator(String token, Long auditUserId, Long carrierId) {
        super(token, auditUserId, carrierId);
    }

    @Override
    public Response<PaginationBaseResponseModel<PickupLocationResponseModel>> getPickupLocationsInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PICKUP_LOCATION + "/" + ApiRoutes.PickupLocationsSubRoute.GET_PICKUP_LOCATIONS_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<PickupLocationResponseModel>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<Long> createPickupLocation(PickupLocationRequestModel pickupLocationRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PICKUP_LOCATION + "/" + ApiRoutes.PickupLocationsSubRoute.CREATE_PICKUP_LOCATION),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                pickupLocationRequestModel);
    }

    @Override
    public Response<List<PickupLocation>> getAllPickupLocations(boolean includeDeleted) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PICKUP_LOCATION + "/" + ApiRoutes.PickupLocationsSubRoute.GET_ALL_PICKUP_LOCATIONS,
                        Collections.singletonMap("includeDeleted", includeDeleted)),
                "GET",
                new TypeToken<Response<List<PickupLocation>>>(){}.getType(),
                null);
    }

    @Override
    public Response<Long> updatePickupLocation(PickupLocationRequestModel pickupLocationRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PICKUP_LOCATION + "/" + ApiRoutes.PickupLocationsSubRoute.UPDATE_PICKUP_LOCATION),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                pickupLocationRequestModel);
    }

    @Override
    public Response<PickupLocationResponseModel> getPickupLocationById(long pickupLocationId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PICKUP_LOCATION + "/" + ApiRoutes.PickupLocationsSubRoute.GET_PICKUP_LOCATION_BY_ID,
                        Collections.singletonMap("id", pickupLocationId)),
                "GET",
                new TypeToken<Response<PickupLocationResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> togglePickupLocation(long pickupLocationId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PICKUP_LOCATION + "/" + ApiRoutes.PickupLocationsSubRoute.TOGGLE_PICKUP_LOCATION,
                        Collections.singletonMap("id", pickupLocationId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }
}