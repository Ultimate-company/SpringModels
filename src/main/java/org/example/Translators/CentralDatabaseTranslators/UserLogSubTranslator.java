package org.example.Translators.CentralDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CentralModels.UserLog;
import org.example.Models.RequestModels.GridRequestModels.GetUserLogsRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CentralDatabaseTranslators.Interfaces.IUserLogSubTranslator;

public class UserLogSubTranslator extends Translator implements IUserLogSubTranslator {

    public UserLogSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<PaginationBaseResponseModel<UserLog>> fetchUserLogsInBatches(GetUserLogsRequestModel getUserLogsRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.USERLOG + "/" + ApiRoutes.UserLogSubRoute.GET_USER_LOGS_IN_BATCHES_BY_USERID),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<UserLog>>>(){}.getType(),
                getUserLogsRequestModel);
    }

    @Override
    public Response<Boolean> logData(long userId, String change, String oldValue, String newValue) {
        return null;
    }

    @Override
    public Response<Boolean> logData(long userId, String newValue, String endPoint) {
        return null;
    }
}
