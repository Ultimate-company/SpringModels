package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Message;

import java.util.List;

@Getter
@Setter
public class MessageRequestModel extends BaseRequest {
    private Message message;
    private List<Long> userIds;
    private List<Long> userGroupIds;
}
