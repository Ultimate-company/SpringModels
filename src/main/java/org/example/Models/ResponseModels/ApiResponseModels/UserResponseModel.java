package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Permissions;
import org.example.Models.CommunicationModels.CentralModels.User;

import java.util.List;

@Getter
@Setter
public class UserResponseModel {
    private User user;
    private Address address;
    private Permissions permissions;
    private List<Long> groupIds;
}
