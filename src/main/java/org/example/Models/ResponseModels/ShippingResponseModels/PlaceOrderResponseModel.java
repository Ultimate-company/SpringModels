package org.example.Models.ResponseModels.ShippingResponseModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceOrderResponseModel {
    public long pickupLocationId;
    public long systemOrderId;

    public long order_id;
    public long shipment_id;
    public String status;
    public String onboarding_completed_now;
    public String awb_code;
    public String courier_company_id;
    public String courier_name;
}