package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class Event {
    // Event details
    private Long eventId;
    private String eventName;
    private String descriptionHtml;
    private String eventType;
    private String priorityStatus;


    // Event date, time, and location
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String timeZone;
    private String location;

    // Event misc
    private String color;
    private String colorLabel;
    private boolean deleted;
    private Long createdByUserId;

    // Misc
    private LocalDateTime createdAt;
    private String notes;
    private LocalDateTime updatedAt;
    private Long auditUserId;
}
