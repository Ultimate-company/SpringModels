package org.example.Translators.CentralDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CentralModels.UserLog;
import org.example.Models.RequestModels.GridRequestModels.GetUserLogsRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;

public interface IUserLogSubTranslator {
    /**
     * Logs a data change made by a user.
     *
     * @param userId    The ID of the user who made the change.
     * @param change    Description of the change made.
     * @param oldValue  Previous value of the data.
     * @param newValue  New value of the data.
     * @return A response indicating whether the data change was successfully logged.
     */
    Response<Boolean> logData(long userId, String change, String oldValue, String newValue);

    /**
     * Logs a data insertion or update made by a user.
     *
     * @param userId    The ID of the user who made the change.
     * @param newValue  New value of the data.
     * @param endPoint  The endpoint where the data insertion or update occurred.
     * @return A response indicating whether the data change was successfully logged.
     */
    Response<Boolean> logData(long userId, String newValue, String endPoint);

    /**
     * Retrieves logs based on user ID.
     *
     * @param getUserLogsRequestModel The request model containing parameters for filtering logs.
     * @return A response containing paginated user logs.
     */
    Response<PaginationBaseResponseModel<UserLog>> fetchUserLogsInBatches(GetUserLogsRequestModel getUserLogsRequestModel);
}