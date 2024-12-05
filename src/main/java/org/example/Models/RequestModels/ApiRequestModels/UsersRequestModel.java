package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Permissions;
import org.example.Models.CommunicationModels.CentralModels.User;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class UsersRequestModel extends BaseRequest
{
    private String email;

    @IsRequired
    @FrontEndVariable
    private User user;

    @IsRequired
    @FrontEndVariable
    private Address address;

    @IsRequired
    @FrontEndVariable
    private Permissions permissions;

    @FrontEndVariable
    private List<Long> userGroupIds;

    @FrontEndVariable
    private String profilePictureBase64;
}