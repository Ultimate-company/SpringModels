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
public class Permissions {
    private long permissionId;

    @IsRequired
    @FrontEndVariable
    private String userPermissions;

    @IsRequired
    @FrontEndVariable
    private String userLogPermissions;

    @IsRequired
    @FrontEndVariable
    private String groupsPermissions;

    @IsRequired
    @FrontEndVariable
    private String messagesPermissions;

    @IsRequired
    @FrontEndVariable
    private String promosPermissions;

    @IsRequired
    @FrontEndVariable
    private String addressPermissions;

    @IsRequired
    @FrontEndVariable
    private String pickupLocationPermissions;

    @IsRequired
    @FrontEndVariable
    private String ordersPermissions;

    @IsRequired
    @FrontEndVariable
    private String paymentsPermissions;

    @IsRequired
    @FrontEndVariable
    private String eventsPermissions;

    @IsRequired
    @FrontEndVariable
    private String productsPermissions;

    @IsRequired
    @FrontEndVariable
    private String supportPermissions;

    @IsRequired
    @FrontEndVariable
    private String apiKeyPermissions;

    @IsRequired
    @FrontEndVariable
    private String leadsPermissions;

    @IsRequired
    @FrontEndVariable
    private String purchaseOrderPermissions;

    @IsRequired
    @FrontEndVariable
    private String salesOrderPermissions;

    @IsRequired
    @FrontEndVariable
    private String webTemplatePermissions;

    @IsRequired
    @FrontEndVariable
    private String packagePermissions;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
