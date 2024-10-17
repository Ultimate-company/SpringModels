package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SupportComments {
    private String commentId;
    private String rawCommentADF;

    // mapping fields
    private Long userId;
    private String ticketId;

    // Tracking Fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}