package org.example.Models.CommunicationModels.CarrierModels;

import java.time.LocalDateTime;

public class Support {
    private long supportId;
    private String rawSupportDetails;
    private String status;
    private long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}