package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.PurchaseOrder;

import java.util.Map;

@Getter
@Setter
public class PurchaseOrderRequestModel extends BaseRequest{
    private PurchaseOrder purchaseOrder;
    private Address address;
    private Map<Long, Integer> productIdQuantityMapping;
}
