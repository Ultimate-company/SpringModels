package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Todo {
    private long todoId;
    private String task;
    private boolean done;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
    private long userId;
}
