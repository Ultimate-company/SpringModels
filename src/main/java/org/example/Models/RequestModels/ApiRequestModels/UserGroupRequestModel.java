package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.example.Models.CommunicationModels.CarrierModels.UserGroup;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class UserGroupRequestModel extends BaseRequest {
    @FrontEndVariable
    @IsRequired
    private UserGroup userGroup;

    @FrontEndVariable
    @IsRequired
    private List<Long> userIds;
}
