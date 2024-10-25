package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.RequestModels.ApiRequestModels.SupportRequestModel;
import org.example.Models.ResponseModels.JiraResponseModels.*;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.ISupportSubTranslator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SupportSubTranslator extends Translator implements ISupportSubTranslator {
    public SupportSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<GetTicketsResponseModel> getSupportTicketsInBatches(int start, int end) {
        Map<String, Object> getParams = new HashMap<>();
        getParams.put("start", start);
        getParams.put("end", end);

        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.GET_SUPPORT_TICKETS_IN_BATCHES,
                        getParams),
                "GET",
                new TypeToken<Response<GetTicketsResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<GetTicketDetailsResponseModel> getTicketDetailsById(String ticketId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.GET_TICKET_DETAILS_BY_ID,
                        Collections.singletonMap("ticketId", ticketId)),
                "GET",
                new TypeToken<Response<GetTicketDetailsResponseModel>>(){}.getType(),
                null);
    }

    @Override
    public Response<Map<String, String>> getAttachmentFromTicket(String ticketId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.GET_ATTACHMENT_FROM_TICKET,
                        Collections.singletonMap("ticketId", ticketId)),
                "GET",
                new TypeToken<Response<Map<String, String>>>(){}.getType(),
                null);
    }

    @Override
    public Response<GetCommentsResponseModel> getCommentsFromTicket(String ticketId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.GET_COMMENTS_FROM_TICKET,
                        Collections.singletonMap("ticketId", ticketId)),
                "GET",
                new TypeToken<Response<Map<String, String>>>(){}.getType(),
                null);
    }

    @Override
    public Response<CreateTicketResponseModel> createTicket(SupportRequestModel supportRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.CREATE_TICKET),
                "PUT",
                new TypeToken<Response<CreateTicketResponseModel>>(){}.getType(),
                supportRequestModel);
    }

    @Override
    public Response<AddCommentResponseModel> addComment(String ticketId, SupportRequestModel supportRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.ADD_COMMENT,
                        Collections.singletonMap("ticketId", ticketId)),
                "PUT",
                new TypeToken<Response<AddCommentResponseModel>>(){}.getType(),
                supportRequestModel);
    }

    @Override
    public Response<Boolean> deleteComment(String ticketId, String commentId) {
        return httpResponse(
                getApiUrl(
                        ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.DELETE_COMMENT,
                        Map.of(
                                "ticketId", ticketId,
                                "commentId", commentId
                        )
                ),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null
        );
    }

    @Override
    public Response<Boolean> editTicket(String ticketId, SupportRequestModel supportRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.EDIT_TICKET,
                        Collections.singletonMap("ticketId", ticketId)),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                supportRequestModel);
    }

    @Override
    public Response<Boolean> editComment(String ticketId, String commentId, SupportRequestModel supportRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.EDIT_COMMENT,
                        Map.of(
                                "ticketId", ticketId,
                                "commentId", commentId
                        )),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                supportRequestModel);
    }

    @Override
    public Response<Boolean> deleteTicket(String ticketId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.SUPPORT + "/" + ApiRoutes.SupportSubRoute.DELETE_TICKET,
                        Collections.singletonMap("ticketId", ticketId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }
}