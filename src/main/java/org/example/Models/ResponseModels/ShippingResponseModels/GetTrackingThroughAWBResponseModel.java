package org.example.Models.ResponseModels.ShippingResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class GetTrackingThroughAWBResponseModel{
    public TrackingData tracking_data;

    @Getter
    @Setter
    public static class QcResponse{
        public String qc_image;
        public String qc_failed_reason;
    }

    @Getter
    @Setter
    public static class ShipmentTrack{
        public int id;
        public String awb_code;
        public int courier_company_id;
        public int shipment_id;
        public int order_id;
        public String pickup_date;
        public String delivered_date;
        public String weight;
        public int packages;
        public String current_status;
        public String delivered_to;
        public String destination;
        public String consignee_name;
        public String origin;
        public Object courier_agent_details;
        public String courier_name;
        public Object edd;
        public String pod;
        public String pod_status;
    }

    @Getter
    @Setter
    public static class ShipmentTrackActivity{
        public String date;
        public String status;
        public String activity;
        public String location;

        @JsonProperty("sr-status")
        public String sr_status;
        @JsonProperty("sr-status-label")
        public String sr_status_label;
    }

    @Getter
    @Setter
    public static class TrackingData{
        public int track_status;
        public int shipment_status;
        public ArrayList<ShipmentTrack> shipment_track;
        public ArrayList<ShipmentTrackActivity> shipment_track_activities;
        public String track_url;
        public String etd;
        public QcResponse qc_response;
    }
}