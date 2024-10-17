package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SalesOrderPackagingAndShipRocketMapping {
    private long salesOrderPackagingMappingId;
    private String productIds;

    // ShipRocket Columns
    private Long shipRocketShipmentId;
    private Long shipRocketOrderId;
    private String shipRocketGeneratedAWB;
    private String shippingCourierId;
    private String shipRocketPickupTokenNumber;
    private String shipRocketManifest;
    private String shipRocketInvoice;
    private String shipRocketPrintInvoice;
    private String shipRocketLabel;

    // Fk's
    private long salesOrderId;
    private long packageId;
    private long pickupLocationId;

    // Logging fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}