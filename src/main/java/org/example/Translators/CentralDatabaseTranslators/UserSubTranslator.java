package org.example.Translators.CentralDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.Permissions;
import org.example.Models.CommunicationModels.CentralModels.User;
import org.example.Models.RequestModels.ApiRequestModels.ImportUsersRequestModel;
import org.example.Models.RequestModels.ApiRequestModels.UsersRequestModel;
import org.example.Models.RequestModels.GridRequestModels.GetUsersRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CentralDatabaseTranslators.Interfaces.IUserSubTranslator;

import java.util.Collections;
import java.util.List;

public class UserSubTranslator extends Translator implements IUserSubTranslator {

    public UserSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<Boolean> isEmailAvailableInSystem(String email) throws Exception {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.IS_EMAIL_AVAILABLE_IN_SYSTEM,
                        Collections.singletonMap("email", email)),
                "GET",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<User> getUserByEmail(String email) {
        return httpResponse(ApiRoutes.ApiControllerNames.USER + "/" + getApiUrl(ApiRoutes.UsersSubRoute.GET_USER_BY_EMAIL,
                        Collections.singletonMap("email", email)),
                "GET",
                new TypeToken<Response<User>>(){}.getType(),
                null);
    }

    @Override
    public Response<User> getUserById(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.GET_USER_BY_ID,
                        Collections.singletonMap("id", id)),
                "GET",
                new TypeToken<Response<User>>(){}.getType(),
                null);
    }

    @Override
    public Response<Long> createUser(UsersRequestModel usersRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.CREATE_USER),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                usersRequestModel);
    }

    @Override
    public Response<Long> toggleUser(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.TOGGLE_USER,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Long>>(){}.getType(),
                null);
    }

    @Override
    public Response<Long> updateUser(UsersRequestModel usersRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.UPDATE_USER),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                usersRequestModel);
    }

    @Override
    public Response<List<User>> fetchUsersInCarrier(boolean includeDeleted) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.FETCH_USERS_IN_CARRIER,
                        Collections.singletonMap("includeDelete", includeDeleted)),
                "GET",
                new TypeToken<Response<List<User>>>(){}.getType(),
                null);
    }

    @Override
    public Response<PaginationBaseResponseModel<User>> fetchUsersInCarrierInBatches(GetUsersRequestModel getUsersRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.GET_USERS_IN_CARRIER_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<User>>>(){}.getType(),
                getUsersRequestModel);
    }

    @Override
    public Response<String> importUsers(ImportUsersRequestModel importUsersRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.IMPORT_USERS),
                "POST",
                new TypeToken<Response<String>>(){}.getType(),
                importUsersRequestModel);
    }

    @Override
    public Response<Permissions> getUserPermissionsById(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER + "/" + ApiRoutes.UsersSubRoute.GET_USER_PERMISSIONS_BY_ID,
                    Collections.singletonMap("id", id)),
                "GET",
                new TypeToken<Response<Permissions>>(){}.getType(),
                null);
    }
}