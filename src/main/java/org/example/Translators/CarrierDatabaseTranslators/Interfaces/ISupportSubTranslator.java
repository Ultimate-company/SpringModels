package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.RequestModels.ApiRequestModels.SupportRequestModel;
import org.example.Models.ResponseModels.JiraResponseModels.*;
import org.example.Models.ResponseModels.Response;

import java.util.List;
import java.util.Map;

public interface ISupportSubTranslator {

    /**
     * Retrieves a batch of support tickets within the specified range.
     *
     * @param start The starting index of the batch.
     * @param end The ending index of the batch.
     * @return Response containing a model with a list of support tickets.
     */
    Response<GetTicketsResponseModel> getSupportTicketsInBatches(int start, int end);

    /**
     * Retrieves the details of a specific support ticket by its ID.
     *
     * @param ticketId The ID of the support ticket.
     * @return Response containing the details of the requested support ticket.
     */
    Response<GetTicketDetailsResponseModel> getTicketDetailsById(String ticketId);

    /**
     * Retrieves attachments from a specific support ticket.
     *
     * @param ticketId The ID of the support ticket.
     * @return Response containing a map of attachment IDs and their corresponding URLs.
     */
    Response<Map<String, String>> getAttachmentFromTicket(String ticketId);

    /**
     * Retrieves comments from a specific support ticket.
     *
     * @param ticketId The ID of the support ticket.
     * @return Response containing the comments of the requested support ticket.
     */
    Response<GetCommentsResponseModel> getCommentsFromTicket(String ticketId);

    /**
     * Creates a new support ticket using the provided JSON content.
     *
     * @param supportRequestModel The JSON string representing the ticket details.
     * @return Response containing the details of the newly created support ticket.
     */
    Response<CreateTicketResponseModel> createTicket(SupportRequestModel supportRequestModel);

    /**
     * Adds a comment to an existing support ticket using the provided JSON content.
     *
     * @param ticketId The ID of the support ticket.
     * @param supportRequestModel The JSON string representing the ticket details.
     * @return Response containing the details of the comment added to the support ticket.
     */
    Response<AddCommentResponseModel> addComment(String ticketId, SupportRequestModel supportRequestModel);

    /**
     * Edits an existing comment on a support ticket using the provided JSON content.
     *
     * @param ticketId The ID of the support ticket.
     * @param commentId The ID of the comment.
     * @param supportRequestModel The JSON string representing the updated comment details.
     * @return A boolean response indicating the edit operation success or failure
     */
    Response<Boolean> editComment(String ticketId, String commentId, SupportRequestModel supportRequestModel);

    /**
     * Deletes a comment from a specified ticket.
     *
     * This method sends a request to the server to delete the comment identified by `commentId`
     * from the ticket identified by `ticketId`. It returns a `Response` object containing the
     * details of the deleted comment, including its ID and other relevant metadata.
     *
     * @param ticketId The ID of the ticket from which the comment is to be deleted.
     * @param commentId The ID of the comment that is to be deleted.
     * @return A boolean response indicating the delete operation success or failure
     */
    Response<Boolean> deleteComment(String ticketId, String commentId);

    /**
     * Edits an existing support ticket using the provided JSON content.
     *
     * @param ticketId The ID of the support ticket.
     * @param supportRequestModel The JSON string representing the updated ticket details.
     * @return Response indicating the success or failure of the edit operation.
     */
    Response<Boolean> editTicket(String ticketId, SupportRequestModel supportRequestModel);

    /**
     * Edits an existing support ticket using the provided JSON content.
     *
     * @param ticketId The ID of the support ticket.
     * @return Response indicating the success or failure of the delete operation.
     */
    Response<Boolean> deleteTicket(String ticketId);
}