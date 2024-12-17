package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.RequestModels.ApiRequestModels.EventRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.EventResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IEventSubTranslator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EventSubTranslator extends Translator implements IEventSubTranslator {
    public EventSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<List<EventResponseModel>> getAllEventsForUserIdBasedOnMonth(long userId, int month) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.EVENT + "/" + ApiRoutes.EventSubRoute.GET_ALL_EVENTS_FOR_USERID_BASED_ON_MONTH,
                        Map.of("userId", userId, "month", month)),
                "GET",
                new TypeToken<Response<List<EventResponseModel>>>(){}.getType(),
                null);
    }

    @Override
    public Response<Long> createEvent(EventRequestModel eventRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.EVENT + "/" + ApiRoutes.EventSubRoute.CREATE_EVENT),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                eventRequestModel);
    }

    @Override
    public Response<Boolean> updateEvent(EventRequestModel eventRequestModel) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.EVENT + "/" + ApiRoutes.EventSubRoute.UPDATE_EVENT),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                eventRequestModel);
    }

    @Override
    public Response<Boolean> toggleEvent(long eventId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.EVENT + "/" + ApiRoutes.EventSubRoute.TOGGLE_EVENT,
                        Collections.singletonMap("eventId", eventId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<EventResponseModel> getEventDetailsById(long eventId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.EVENT + "/" + ApiRoutes.EventSubRoute.GET_EVENT_DETAILS_BY_ID,
                        Collections.singletonMap("eventId", eventId)),
                "GET",
                new TypeToken<Response<EventResponseModel>>(){}.getType(),
                null);
    }
}
