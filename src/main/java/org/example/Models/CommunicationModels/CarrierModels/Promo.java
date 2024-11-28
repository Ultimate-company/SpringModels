package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class Promo {
    private Long promoId;

    @FrontEndVariable
    @IsRequired
    private String description;
    private boolean deleted;

    @FrontEndVariable
    @IsRequired
    private boolean percent;

    @FrontEndVariable
    @IsRequired
    private double discountValue;

    @FrontEndVariable
    @IsRequired
    private String promoCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}