package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.PickupLocation;

@Getter
@Setter
public class PickupLocationResponseModel {
    private PickupLocation pickupLocation;
    private Address address;
}
