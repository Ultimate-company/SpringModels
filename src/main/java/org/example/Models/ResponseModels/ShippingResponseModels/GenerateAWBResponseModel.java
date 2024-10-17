package org.example.Models.ResponseModels.ShippingResponseModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateAWBResponseModel {
    private int awb_assign_status;
    private Response response;
    private long systemOrderId;

    @Getter
    @Setter
    public static class Response {
        private Data data;
    }

    @Getter
    @Setter
    public static class Data {
        private int courier_company_id;
        private String awb_code;
        private int cod;
        private long order_id;
        private long shipment_id;
        private int awb_code_status;
        private AssignedDateTime assigned_date_time;
        private double applied_weight;
        private int company_id;
        private String courier_name;
        private String child_courier_name;
        private String pickup_scheduled_date;
        private String routing_code;
        private String rto_routing_code;
        private String invoice_no;
        private String transporter_id;
        private String transporter_name;
        private ShippedBy shipped_by;
    }

    @Getter
    @Setter
    public static class AssignedDateTime {
        private String date;
        private int timezone_type;
        private String timezone;
    }

    @Getter
    @Setter
    public static class ShippedBy {
        private String shipper_company_name;
        private String shipper_address_1;
        private String shipper_address_2;
        private String shipper_city;
        private String shipper_state;
        private String shipper_country;
        private String shipper_postcode;
        private int shipper_first_mile_activated;
        private String shipper_phone;
        private double lat;
        private double lng;
        private String shipper_email;
        private String rto_company_name;
        private String rto_address_1;
        private String rto_address_2;
        private String rto_city;
        private String rto_state;
        private String rto_country;
        private String rto_postcode;
        private String rto_phone;
        private String rto_email;
    }
}
