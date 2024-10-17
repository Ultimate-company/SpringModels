package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.PickupLocation;

@Getter
@Setter
public class PickupLocationRequestModel extends BaseRequest {
    private PickupLocation pickupLocation;
    private Address address;
    private boolean isEdit;
}