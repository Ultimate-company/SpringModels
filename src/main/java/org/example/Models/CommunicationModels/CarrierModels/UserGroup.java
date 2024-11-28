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
public class UserGroup {
    private Long userGroupId;

    @FrontEndVariable
    @IsRequired
    private String name;

    @FrontEndVariable
    @IsRequired
    private String description;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}
