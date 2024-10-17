package org.example.Models.ResponseModels.ShippingResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.Package;
import org.example.Models.CommunicationModels.CarrierModels.Product;
import org.example.Models.ResponseModels.ApiResponseModels.PickupLocationResponseModel;

import java.util.List;

@Getter
@Setter
public class PackagingEstimateResponseModel {
    private long packageId;
    private List<Long> productIds;
    private PickupLocationResponseModel pickupLocationResponseModel;

    // used only on front-end
    private int serialNo;
    private Package _package;
    private List<Product> products;
}
