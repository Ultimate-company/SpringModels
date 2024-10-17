package org.example.Models.CommunicationModels.CentralModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserLog {
    private long logId;
    private String change;
    private String oldValue;
    private String newValue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
    private long userId;
}