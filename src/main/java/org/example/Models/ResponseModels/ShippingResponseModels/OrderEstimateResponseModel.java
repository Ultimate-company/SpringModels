package org.example.Models.ResponseModels.ShippingResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.*;
import org.example.Models.CommunicationModels.CarrierModels.Package;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OrderEstimateResponseModel {
    private long systemOrderId;
    private String orderId;
    private Date orderDate;
    private Package _package;
    private List<Product> products;
    private Map<Long, Integer> productIdQuantityMapping;
    private Map<Long, Double> productIdPriceMapping;
    private PickupLocation pickupLocation;
    private Address billingAddress;
    private Address shippingAddress;
    private boolean optedForInsurance;
    private PaymentInfo paymentInfo;
}
