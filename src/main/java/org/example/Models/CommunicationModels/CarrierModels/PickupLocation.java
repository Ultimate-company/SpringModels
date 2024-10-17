package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PickupLocation {
    private long pickupLocationId;
    private String addressNickName;
    private boolean deleted;
    private long pickupLocationAddressId;
    private long shipRocketPickupLocationId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
