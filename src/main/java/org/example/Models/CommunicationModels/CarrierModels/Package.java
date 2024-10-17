package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Package {
    private long packageId;
    private int length;
    private int breadth;
    private int height;
    private boolean deleted;
    private int quantity;
    private double pricePerQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}