package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Permissions {
    private long permissionId;
    private String userPermissions;
    private String userLogPermissions;
    private String groupsPermissions;
    private String messagesPermissions;
    private String promosPermissions;
    private String addressPermissions;
    private String pickupLocationPermissions;
    private String ordersPermissions;
    private String paymentsPermissions;
    private String eventsPermissions;
    private String productsPermissions;
    private String supportPermissions;
    private String apiKeyPermissions;
    private String leadsPermissions;
    private String purchaseOrderPermissions;
    private String salesOrderPermissions;
    private String webTemplatePermissions;
    private String packagePermissions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
