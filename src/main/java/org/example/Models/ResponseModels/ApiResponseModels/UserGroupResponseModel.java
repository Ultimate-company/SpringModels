package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.UserGroup;

import java.util.List;

@Getter
@Setter
public class UserGroupResponseModel {
    private UserGroup userGroup;
    private int userCount;
    private List<Long> userIds;
}
