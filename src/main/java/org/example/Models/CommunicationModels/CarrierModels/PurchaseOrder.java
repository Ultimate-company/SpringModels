package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PurchaseOrder {
    private Long purchaseOrderId;
    private LocalDateTime expectedShipmentDate;
    private String vendorNumber;
    private boolean deleted;
    private String termsConditionsHtml;
    private String termsConditionsMarkdown;
    private String orderReceipt;
    private boolean approved;
    private Long salesOrderId;
    private Long approvedByUserId;
    private Long assignedLeadId;
    private Long createdByUserId;
    private Long purchaseOrderAddressId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
