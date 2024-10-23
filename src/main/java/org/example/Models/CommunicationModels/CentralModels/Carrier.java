package org.example.Models.CommunicationModels.CentralModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.IgnoreCopy;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class Carrier {
    private long carrierId;
    private String name;
    private String description;
    private String databaseName;
    private String sendgridApikey;
    private String sendgridEmailAddress;
    private boolean isDeleted;
    private String image;
    private String website;
    private String sendgridSenderName;
    private String razorpayApikey;
    private String razorpayApiSecret;
    private String shipRocketEmail;
    private String shipRocketPassword;
    private String jiraUserName;
    private String jiraPassword;
    private String jiraProjectUrl;
    private String jiraProjectKey;
    private String issueTypes;
    private String boxDeveloperToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;

    @IgnoreCopy
    private String imageBase64;
}