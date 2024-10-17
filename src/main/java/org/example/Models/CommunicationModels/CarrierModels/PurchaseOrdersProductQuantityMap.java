package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PurchaseOrdersProductQuantityMap {
    private long purchaseOrdersProductQuantityMapId;
    private int quantity;
    private long productId;
    private long purchaseOrderId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}

