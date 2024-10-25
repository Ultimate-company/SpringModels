package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.RequestModels.ApiRequestModels.MessageRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.MessageResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IMessageSubTranslator;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageSubTranslator extends Translator implements IMessageSubTranslator {
    public MessageSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<PaginationBaseResponseModel<MessageResponseModel>> getMessagesInBatches(PaginationBaseRequestModel paginationBaseRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.GET_MESSAGES_IN_BATCHES),
                "POST",
                new TypeToken<Response<PaginationBaseResponseModel<MessageResponseModel>>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    public Response<MessageResponseModel> getMessageDetailsById(long messageId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.GET_MESSAGE_DETAILS_BY_ID,
                        Collections.singletonMap("id", messageId)),
                "GET",
                new TypeToken<Response<MessageResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<List<Long>> getUsersInMessages(long messageId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.GET_USERS_IN_MESSAGE,
                        Collections.singletonMap("id", messageId)),
                "GET",
                new TypeToken<Response<List<Long>>>(){}.getType(),
                null);
    }

    @Override
    public Response<List<Long>> getUserGroupsInMessage(long messageId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.GET_USER_GROUPS_IN_MESSAGE,
                        Collections.singletonMap("id", messageId)),
                "GET",
                new TypeToken<Response<List<Long>>>(){}.getType(),
                null);
    }

    @Override
    public Response<List<MessageResponseModel>> getMessagesByUserId(long userId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.GET_MESSAGES_BY_USER_ID,
                        Collections.singletonMap("id", userId)),
                "GET",
                new TypeToken<Response<List<MessageResponseModel>>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> setMessageReadByUserIdAndMessageId(long userId, long messageId) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("messageId", messageId);
        queryParams.put("userId", userId);

        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.SET_MESSAGE_READ_BY_USER_ID_AND_MESSAGE_ID,
                        queryParams),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Long> createMessage(MessageRequestModel messageRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.CREATE_MESSAGE),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                messageRequestModel);
    }

    @Override
    public Response<Long> updateMessage(MessageRequestModel messageRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.UPDATE_MESSAGE),
                "POST",
                new TypeToken<Response<Long>>(){}.getType(),
                messageRequestModel);
    }

    @Override
    public Response<Boolean> toggleMessage(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.MESSAGE + "/" + ApiRoutes.MessagesSubRoute.TOGGLE_MESSAGE,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }
}