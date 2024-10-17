package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class SalesOrdersProductQuantityMap {
    private long salesOrdersProductQuantityMapId;
    private int quantity;
    private double pricePerQuantityPerProduct;
    private long productId;
    private long salesOrderId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}

