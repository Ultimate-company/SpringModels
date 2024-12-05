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
public class PurchaseOrder {
    private Long purchaseOrderId;

    @FrontEndVariable
    @IsRequired
    private LocalDateTime expectedShipmentDate;

    @FrontEndVariable
    @IsRequired
    private String vendorNumber;
    private boolean deleted;

    @FrontEndVariable
    @IsRequired
    private String termsConditionsHtml;

    @FrontEndVariable
    private String orderReceipt;
    private boolean approved;

    @FrontEndVariable
    private Long approvedByUserId;

    @FrontEndVariable
    @IsRequired
    private long assignedLeadId;
    private Long createdByUserId;
    private Long purchaseOrderAddressId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}
