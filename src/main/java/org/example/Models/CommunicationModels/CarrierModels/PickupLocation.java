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
public class PickupLocation {
    private Long pickupLocationId;

    @FrontEndVariable
    @IsRequired
    private String addressNickName;
    private boolean deleted;
    private long pickupLocationAddressId;
    private long shipRocketPickupLocationId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}
