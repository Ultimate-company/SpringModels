package org.example.Models.RequestModels.ApiRequestModels;


import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Permissions;
import org.example.Models.CommunicationModels.CentralModels.User;

import java.util.List;

@Getter
@Setter
public class UsersRequestModel extends BaseRequest
{
    private String email;
    private User user;
    private Address address;
    private Permissions permissions;
    private List<Long> userGroupIds;
}