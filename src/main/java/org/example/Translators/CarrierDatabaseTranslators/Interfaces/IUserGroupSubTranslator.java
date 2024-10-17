package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.UserGroup;
import org.example.Models.RequestModels.ApiRequestModels.UserGroupRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.UserGroupResponseModel;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface IUserGroupSubTranslator {
    /**
     * Retrieves user groups in batches based on the specified pagination request.
     *
     * @param paginationBaseRequestModel The pagination request model.
     * @return A response containing the paginated user groups.
     */
    Response<PaginationBaseResponseModel<UserGroupResponseModel>> getUserGroupsInBatches(
            PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Retrieves the details of a user group by the specified group ID.
     *
     * @param userGroupId The ID of the user group.
     * @return A response containing the user group details.
     */
    Response<UserGroupResponseModel> getUserGroupDetailsById(long userGroupId);

    /**
     * Inserts a new user group.
     *
     * @param userGroupRequestModel The user group object to insert.
     * @return A response containing the ID of the inserted user group.
     */
    Response<Long> createUserGroup(UserGroupRequestModel userGroupRequestModel);

    /**
     * Edits an existing user group.
     *
     * @param userGroupRequestModel The user group object to edit is in it along with the userids.
     * @return A response indicating the success of the edit operation.
     */
    Response<Long> updateUserGroup(UserGroupRequestModel userGroupRequestModel);

    /**
     * Toggles the status of a user group.
     *
     * @param userGroupId   The ID of the user group.
     * @return A response indicating the success of the toggle operation.
     */
    Response<Boolean> toggleUserGroup(long userGroupId);

    /**
     * Fetches all the group ids the user is a part of
     *
     * @param userId   The ID of the user.
     * @return A response with user group ids the user is a part of
     */
    Response<List<Long>> getUserGroupIdsByUserId(long userId);
}
