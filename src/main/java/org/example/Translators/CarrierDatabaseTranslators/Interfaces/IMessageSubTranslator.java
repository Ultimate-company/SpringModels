package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.RequestModels.ApiRequestModels.MessageRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.MessageResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface IMessageSubTranslator {
    /**
     * Adds a new message.
     *
     * @param messageRequestModel The message to add and the user ids associated with it.
     * @return A response containing the ID of the added message.
     */
    Response<Long> createMessage(MessageRequestModel messageRequestModel);

    /**
     * Edits an existing message.
     *
     * @param messageRequestModel The message to edit and the user ids associated with it.
     * @return A response indicating the success of the edit operation.
     */
    Response<Long> updateMessage(MessageRequestModel messageRequestModel);

    /**
     * Toggles the delete state of a message.
     *
     * @param messageId The ID of the message to toggle.
     * @return A response indicating the success of the toggle operation.
     */
    Response<Boolean> toggleMessage(long messageId);

    /**
     * Retrieves messages in batches based on the specified request model.
     *
     * @param paginationBaseRequestModel The request model for retrieving messages.
     * @return A response containing a pagination model of messages.
     */
    Response<PaginationBaseResponseModel<MessageResponseModel>> getMessagesInBatches(
            PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Retrieves the details of a message by its ID.
     *
     * @param messageId The ID of the message to retrieve.
     * @return A response containing the details of the message.
     */
    Response<MessageResponseModel> getMessageDetailsById(long messageId);

    /**
     * Retrieves the userids the message is addressed to
     *
     * @param messageId The ID of the message to retrieve.
     * @return A response containing the details of the message.
     */
    Response<List<Long>> getUsersInMessages(long messageId);

    /**
     * Retrieves the usergroupids the message is addressed to
     *
     * @param messageId The ID of the message to retrieve.
     * @return A response containing the details of the message.
     */
    Response<List<Long>> getUserGroupsInMessage(long messageId);

    /**
     * Retrieves the messages the user has been sent out
     *
     * @param userId The ID of the user to retrieve the messages for.
     * @return A response containing the details of all the message.
     */
    Response<List<MessageResponseModel>> getMessagesByUserId(long userId);
    /**
     * Retrieves the messages the user has been sent out
     *
     * @param userId the user id who is reading the message.
     * @param messageId the message the user read.
     * @return A boolean response stating whether the db operation was successful.
     */
    Response<Boolean> setMessageReadByUserIdAndMessageId(long userId, long messageId);
}
