package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Lead;
import org.example.Models.CommunicationModels.CentralModels.User;

@Getter
@Setter
public class LeadResponseModel {
    private Lead lead;
    private Address address;
    private User createdBy;
    private User assignedAgent;
}
