package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.*;
import org.example.Models.CommunicationModels.CentralModels.User;

import java.util.List;

@Getter
@Setter
public class SalesOrderResponseModel {
    private SalesOrder salesOrder;
    private PurchaseOrder purchaseOrder;
    private PaymentInfo paymentInfo;
    private Address billingAddress;
    private Address shippingAddress;
    private Lead lead;
    private Address purchaseOrderAddress;
    private User purchaseOrderCreatedBy;
    private User purchaseOrderApprovedBy;
    private List<SalesOrderPackagingAndShipRocketMapping> salesOrderPackagingMappings;
}
