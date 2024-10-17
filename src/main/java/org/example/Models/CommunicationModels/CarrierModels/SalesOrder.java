package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class SalesOrder {
    private long salesOrderId;
    private String termsAndConditionsMarkdown;
    private String termsAndConditionsHtml;
    private boolean deleted;
    private long paymentId;
    private long billingAddressId;
    private long shippingAddressId;
    private long purchaseOrderId;
    private long createdByUserId;
    private int salesOrderStatus;
    private boolean optedForInsurance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}