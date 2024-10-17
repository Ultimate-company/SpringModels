package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Promo {
    private long promoId;
    private String description;
    private boolean deleted;
    private boolean percent;
    private double discountValue;
    private String promoCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}