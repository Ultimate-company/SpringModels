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
public class Package {
    private Long packageId;

    @FrontEndVariable
    @IsRequired
    private int length;

    @FrontEndVariable
    @IsRequired
    private int breadth;

    @FrontEndVariable
    @IsRequired
    private int height;
    private boolean deleted;

    @FrontEndVariable
    @IsRequired
    private int quantity;

    @FrontEndVariable
    @IsRequired
    private double pricePerQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}