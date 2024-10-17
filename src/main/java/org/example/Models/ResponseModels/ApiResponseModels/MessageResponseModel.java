package org.example.Models.ResponseModels.ApiResponseModels;

import java.util.HashSet;

import org.example.Models.CommunicationModels.CarrierModels.Message;
import org.example.Models.CommunicationModels.CentralModels.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseModel {
    private boolean read;
    private Message message;
    private User user;
    private HashSet<Long> userGroupIds;
    private HashSet<Long> userIds;
    private int totalUsers;
    private int totalUserGroups;
}
