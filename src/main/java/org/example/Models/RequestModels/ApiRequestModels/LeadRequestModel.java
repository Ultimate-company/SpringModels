package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Lead;

@Getter
@Setter
public class LeadRequestModel extends BaseRequest {
    private Lead lead;
    private Address address;
}
