package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Lead;
import org.example.Models.CommunicationModels.CarrierModels.PurchaseOrder;
import org.example.Models.CommunicationModels.CentralModels.User;

import java.util.Map;

@Getter
@Setter
public class PurchaseOrderResponseModel {
    private PurchaseOrder purchaseOrder;
    private Address address;
    private Lead lead;
    private User createdByUser;
    private User approvedByUser;
    private Map<Long, Integer> productIdQuantityMapping;
    private Map<Long, Double> productIdPriceMapping;
    private Map<Long, Double> productIdDiscountMapping;
}
