package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.CommunicationModels.CarrierModels.PaymentInfo;
import org.example.Models.CommunicationModels.CarrierModels.SalesOrder;
import org.example.Models.CommunicationModels.CarrierModels.SalesOrdersProductQuantityMap;
import org.example.Models.ResponseModels.ShippingResponseModels.PackagingEstimateResponseModel;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SalesOrderRequestModel {
    private SalesOrder salesOrder;
    private Address billingAddress;
    private Address shippingAddress;
    private PaymentInfo paymentInfo;
    private List<SalesOrdersProductQuantityMap> salesOrdersProductQuantityMaps;
    private List<PackagingEstimateResponseModel> packagingEstimateResponseModels;
    private List<SelectedCourier> selectedCouriers;

    @Getter
    @Setter
    public static class SelectedCourier {
        private long pickupLocationId;
        private String availableCourierId;
        private Date shipmentPickupDate;
    }
}