package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Lead {
    private long leadId;
    private String annualRevenue;
    private String company;
    private Integer companySize;
    private String email;
    private String firstName;
    private String fax;
    private String lastName;
    private String leadStatus;
    private String phone;
    private String title;
    private String website;
    private boolean deleted;
    private long addressId;
    private long createdById;
    private Long assignedAgentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
