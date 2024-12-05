package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.PickupLocation;

@Getter
@Setter
@Accessors(chain = true)
public class PickupLocationRequestModel extends BaseRequest {
    @FrontEndVariable
    @IsRequired
    private PickupLocation pickupLocation;

    @FrontEndVariable
    @IsRequired
    private Address address;

    private boolean isEdit;
}