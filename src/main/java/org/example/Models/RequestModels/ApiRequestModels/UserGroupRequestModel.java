package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.UserGroup;

import java.util.List;

@Getter
@Setter
public class UserGroupRequestModel extends BaseRequest {
    private UserGroup userGroup;
    private List<Long> userIds;
}
