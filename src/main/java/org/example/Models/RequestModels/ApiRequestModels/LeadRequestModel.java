package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Lead;

@Getter
@Setter
@Accessors(chain = true)
public class LeadRequestModel extends BaseRequest {
    @FrontEndVariable
    @IsRequired
    private Lead lead;

    @FrontEndVariable
    @IsRequired
    private Address address;
}
