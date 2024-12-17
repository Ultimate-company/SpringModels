package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.Event;
import org.example.Models.RequestModels.ApiRequestModels.EventRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.EventResponseModel;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface IEventSubTranslator {
    /**
     * Retrieves all events for a user based on the specified month.
     *
     * @param userId The ID of the user.
     * @param month The month to filter events by.
     * @return A response containing the list of events.
     */
    Response<List<EventResponseModel>> getAllEventsForUserIdBasedOnMonth(long userId, int month);

    /**
     * Creates a new event.
     *
     * @param eventRequestModel The event to create.
     * @return A response containing the ID of the created event.
     */
    Response<Long> createEvent(EventRequestModel eventRequestModel);

    /**
     * Updates an existing event.
     *
     * @param eventRequestModel The event with updated information.
     * @return A response indicating the success or failure of the operation.
     */
    Response<Boolean> updateEvent(EventRequestModel eventRequestModel);

    /**
     * Toggles the status of an event by its ID.
     *
     * @param eventId The ID of the event to toggle.
     * @return A response indicating the success or failure of the operation.
     */
    Response<Boolean> toggleEvent(long eventId);

    /**
     * Retrieves the details of an event by its ID.
     *
     * @param eventId The ID of the event to retrieve.
     * @return A response containing the event details.
     */
    Response<EventResponseModel> getEventDetailsById(long eventId);
}
