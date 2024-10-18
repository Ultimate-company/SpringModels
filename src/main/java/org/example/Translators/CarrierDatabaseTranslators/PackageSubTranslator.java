package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.Package;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IPackageSubTranslator;

import java.util.Collections;
import java.util.List;

public class PackageSubTranslator extends Translator implements IPackageSubTranslator {
    public PackageSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<Long> createPackage(Package _package) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PACKAGE + "/" + ApiRoutes.PackageSubRoute.CREATE_PACKAGE),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                _package);
    }

    @Override
    public Response<Long> updatePackage(Package _package) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PACKAGE + "/" + ApiRoutes.PackageSubRoute.UPDATE_PACKAGE),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                _package);
    }

    @Override
    public Response<Boolean> togglePackage(long packageId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PACKAGE + "/" + ApiRoutes.PackageSubRoute.TOGGLE_PACKAGE,
                Collections.singletonMap("id", packageId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<PaginationBaseResponseModel<Package>> getPackagesInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PACKAGE + "/" + ApiRoutes.PackageSubRoute.GET_PACKAGES_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<Package>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<Package> getPackageById(long packageId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PACKAGE + "/" + ApiRoutes.PackageSubRoute.GET_PACKAGE_BY_ID,
                        Collections.singletonMap("id", packageId)),
                "GET",
                new TypeToken<Response<Package>>(){}.getType(),
                null);
    }

    @Override
    public Response<List<Package>> getAllPackagesInSystem() {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PACKAGE + "/" + ApiRoutes.PackageSubRoute.GET_ALL_PACKAGES_IN_SYSTEM),
                "GET",
                new TypeToken<Response<List<Package>>>(){}.getType(),
                null);
    }
}