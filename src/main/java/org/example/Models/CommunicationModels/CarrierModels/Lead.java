package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class Lead {
    private Long leadId;

    @FrontEndVariable
    private String annualRevenue;

    @FrontEndVariable
    @IsRequired
    private String company;

    @FrontEndVariable
    private Integer companySize;

    @FrontEndVariable
    @IsRequired
    private String email;

    @FrontEndVariable
    @IsRequired
    private String firstName;

    @FrontEndVariable
    private String fax;

    @FrontEndVariable
    @IsRequired
    private String lastName;

    @FrontEndVariable
    @IsRequired
    private String leadStatus;

    @FrontEndVariable
    @IsRequired
    private String phone;

    @FrontEndVariable
    @IsRequired
    private String title;

    @FrontEndVariable
    private String website;
    private boolean deleted;
    private long addressId;
    private long createdById;

    @FrontEndVariable
    @IsRequired
    private Long assignedAgentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}
