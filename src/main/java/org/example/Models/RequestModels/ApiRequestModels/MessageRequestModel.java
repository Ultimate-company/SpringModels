package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.example.Models.CommunicationModels.CarrierModels.Message;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class MessageRequestModel extends BaseRequest {
    @FrontEndVariable
    @IsRequired
    private Message message;

    @FrontEndVariable
    @IsRequired
    private List<Long> userIds;

    @FrontEndVariable
    @IsRequired
    private List<Long> userGroupIds;
}
