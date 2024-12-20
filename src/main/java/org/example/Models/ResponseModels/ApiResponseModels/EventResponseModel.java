package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Models.CommunicationModels.CarrierModels.Event;
import org.example.Models.CommunicationModels.CentralModels.User;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class EventResponseModel {
    private Event event;
    private List<Long> attendees;
    private Map<Long, Boolean> userIdRsvpMapping;

    private List<User> acceptedUsers;
    private List<User> declinedUsers;
    private List<User> unknownUsers;
}