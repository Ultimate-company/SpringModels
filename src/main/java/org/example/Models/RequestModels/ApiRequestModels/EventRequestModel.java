package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Models.CommunicationModels.CarrierModels.Event;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class EventRequestModel {
    private Event event;
    private List<Long> attendees;
    private Boolean rsvp;
}