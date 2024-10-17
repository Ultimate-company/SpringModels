package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.PickupLocation;
import org.example.Models.RequestModels.ApiRequestModels.PickupLocationRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.PickupLocationResponseModel;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface IPickupLocationSubTranslator {
    /**
     * Retrieves pickup locations in batches.
     *
     * @param paginationBaseRequestModel The pagination and filtering parameters.
     * @return A response containing a batch of pickup locations.
     */
    Response<PaginationBaseResponseModel<PickupLocationResponseModel>> getPickupLocationsInBatches(
            PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Adds a new pickup location.
     *
     * @param pickupLocationRequestModel The pickup location to add.
     * @return A response containing the ID of the added pickup location.
     */
    Response<Long> createPickupLocation(PickupLocationRequestModel pickupLocationRequestModel) throws Exception;

    /**
     * Retrieves all pickup locations.
     *
     * @return A response containing a list of all pickup locations.
     */
    Response<List<PickupLocation>> getAllPickupLocations(boolean includeDeleted);

    /**
     * Updates an existing pickup location.
     *
     * @param pickupLocationRequestModel The pickup location to update.
     * @return A response indicating the success of the update operation.
     */
    Response<Long> updatePickupLocation(PickupLocationRequestModel pickupLocationRequestModel) throws Exception;

    /**
     * Get Pickup location by id
     *
     * @param pickupLocationId The pickup location id to get.
     * @return A response fetching the pickup location.
     */
    Response<PickupLocationResponseModel> getPickupLocationById(long pickupLocationId);

    /**
     * toggle a pickup loaction by id
     *
     * @param pickupLocationId The pickup location id to toggle.
     * @return A boolean response
     */
    Response<Boolean> togglePickupLocation(long pickupLocationId);
}
