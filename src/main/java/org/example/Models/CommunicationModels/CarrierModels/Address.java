package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Address {
    private long addressId;
    private String line1;
    private String line2;
    private String landmark;
    private String state;
    private String city;
    private String zipCode;
    private String nameOnAddress;
    private String phoneOnAddress;
    private String addressLabel;
    private String emailAtAddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
    private Long userId;
}

