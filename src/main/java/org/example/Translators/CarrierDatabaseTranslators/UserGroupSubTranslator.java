package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.UserGroup;
import org.example.Models.RequestModels.ApiRequestModels.UserGroupRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.UserGroupResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IUserGroupSubTranslator;

import java.util.Collections;
import java.util.List;

public class UserGroupSubTranslator extends Translator implements IUserGroupSubTranslator {
    public UserGroupSubTranslator(String token, Long auditUserId, Long carrierId) {
        super(token, auditUserId, carrierId);
    }

    @Override
    public Response<PaginationBaseResponseModel<UserGroupResponseModel>> getUserGroupsInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER_GROUP + "/" + ApiRoutes.UserGroupsSubRoute.GET_USER_GROUPS_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<UserGroupResponseModel>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<UserGroupResponseModel> getUserGroupDetailsById(long userGroupId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER_GROUP + "/" + ApiRoutes.UserGroupsSubRoute.GET_USER_GROUP_DETAILS_BY_ID,
                        Collections.singletonMap("id", userGroupId)),
                "GET",
                new TypeToken<Response<UserGroupResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<Long> createUserGroup(UserGroupRequestModel userGroupRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER_GROUP + "/" + ApiRoutes.UserGroupsSubRoute.CREATE_USER_GROUP),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                userGroupRequestModel);
    }

    @Override
    public Response<Long> updateUserGroup(UserGroupRequestModel userGroupRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER_GROUP + "/" + ApiRoutes.UserGroupsSubRoute.UPDATE_USER_GROUP),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                userGroupRequestModel);
    }

    @Override
    public Response<Boolean> toggleUserGroup(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER_GROUP + "/" + ApiRoutes.UserGroupsSubRoute.TOGGLE_USER_GROUP,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<List<Long>> getUserGroupIdsByUserId(long userId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USER_GROUP + "/" + ApiRoutes.UserGroupsSubRoute.GET_USER_GROUP_IDS_BY_USERID,
                        Collections.singletonMap("id", userId)),
                "GET",
                new TypeToken<Response<List<Long>>>(){}.getType(),
                null);
    }
}