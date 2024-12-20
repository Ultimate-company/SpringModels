package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Permissions;
import org.example.Models.CommunicationModels.CentralModels.User;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class UserResponseModel {
    private User user;
    private Address address;
    private Permissions permissions;
    private List<Long> groupIds;
}
