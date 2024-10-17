package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.Package;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface IPackageSubTranslator {
    /**
     * Adds a new package.
     *
     * @param _package The package to be added in the system.
     * @return A response containing the ID of the added package.
     */
    Response<Long> createPackage(Package _package);

    /**
     * Updates an existing package.
     *
     * @param _package The package to be updated in the system.
     * @return A response containing the ID of the added package.
     */
    Response<Long> updatePackage(Package _package);

    /**
     * Toggles the delete state of a package.
     *
     * @param packageId The ID of the package to toggle.
     * @return A response indicating the success of the toggle operation.
     */
    Response<Boolean> togglePackage(long packageId);

    /**
     * Retrieves packages in batches based on the specified request model.
     *
     * @param paginationBaseRequestModel The request model for retrieving packages.
     * @return A response containing a pagination model of packages.
     */
    Response<PaginationBaseResponseModel<Package>> getPackagesInBatches(
            PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Gets package details by id.
     *
     * @param packageId The package id of the package you want to retrieve.
     * @return A response containing the package.
     */
    Response<Package> getPackageById(long packageId);

    /**
     * Gets all the packages in the system.
     *
     * @return A response containing all the packages in the system.
     */
    Response<List<Package>> getAllPackagesInSystem();
}