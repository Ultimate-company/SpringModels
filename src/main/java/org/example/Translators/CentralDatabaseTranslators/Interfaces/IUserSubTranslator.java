package org.example.Translators.CentralDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.Permissions;
import org.example.Models.CommunicationModels.CentralModels.User;
import org.example.Models.RequestModels.ApiRequestModels.ImportUsersRequestModel;
import org.example.Models.RequestModels.ApiRequestModels.UsersRequestModel;
import org.example.Models.RequestModels.GridRequestModels.GetUsersRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface IUserSubTranslator {
    /**
     * Checks if the provided email is available in the system.
     * @param email The email to check.
     * @return Response indicating whether the email is available or not.
     */
    Response<Boolean> isEmailAvailableInSystem(String email) throws Exception;

    /**
     * Retrieves a user by their email.
     * @param email The email of the user.
     * @return Response containing the user information.
     */
    Response<User> getUserByEmail(String email);

    /**
     * Retrieves a user by their ID.
     * @param id The ID of the user.
     * @return Response containing the user information.
     */
    Response<User> getUserById(long id);

    /**
     * Creates a new user.
     * @param usersRequestModel The request model containing user information.
     * @return Response containing the ID of the created user.
     */
    Response<Long> createUser(UsersRequestModel usersRequestModel);

    /**
     * Toggles the status of a user (active/inactive).
     * @param id The ID of the user to toggle.
     * @return Response containing the ID of the toggled user.
     */
    Response<Long> toggleUser(long id);

    /**
     * Updates user details.
     * @param usersRequestModel The request model containing updated user information.
     * @return Response indicating the success of the update operation.
     */
    Response<Long> updateUser(UsersRequestModel usersRequestModel);

    /**
     * Fetches users in a carrier.
     * @param includeDeleted Flag indicating whether to include deleted users.
     * @return Response containing the list of users.
     */
    Response<List<User>> fetchUsersInCarrier(boolean includeDeleted);

    /**
     * Fetches users in a carrier in batches.
     * @param getUsersRequestModel The request model specifying batch parameters.
     * @return Response containing paginated user data.
     */
    Response<PaginationBaseResponseModel<User>> fetchUsersInCarrierInBatches(GetUsersRequestModel getUsersRequestModel);

    /**
     * Imports users into the system.
     * @param importUsersRequestModel The request model containing users to import.
     * @return Response indicating the result of the import operation.
     */
    Response<String> importUsers(ImportUsersRequestModel importUsersRequestModel) throws Exception;

    /**
     * Imports users into the system.
     * @param id The id of the user of which the permissions are to be fetch.
     * @return Response with the permissions object.
     */
    Response<Permissions> getUserPermissionsById(long id);
}
