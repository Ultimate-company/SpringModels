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
public class Address {
    private long addressId;

    @IsRequired
    @FrontEndVariable
    private String line1;

    @IsRequired
    @FrontEndVariable
    private String line2;

    @FrontEndVariable
    private String landmark;

    @IsRequired
    @FrontEndVariable
    private String state;

    @IsRequired
    @FrontEndVariable
    private String city;

    @IsRequired
    @FrontEndVariable
    private String zipCode;

    @IsRequired
    @FrontEndVariable
    private String nameOnAddress;

    @IsRequired
    @FrontEndVariable
    private String phoneOnAddress;

    @FrontEndVariable
    private String addressLabel;

    @FrontEndVariable
    private String emailAtAddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
    private Long userId;
}