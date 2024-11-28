package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.PurchaseOrder;

import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class PurchaseOrderRequestModel extends BaseRequest {
    @FrontEndVariable
    @IsRequired
    private PurchaseOrder purchaseOrder;

    @FrontEndVariable
    @IsRequired
    private Address address;

    @FrontEndVariable
    @IsRequired
    private Map<Long, Integer> productIdQuantityMapping;
}
