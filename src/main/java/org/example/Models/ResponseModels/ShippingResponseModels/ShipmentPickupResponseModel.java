package org.example.Models.ResponseModels.ShippingResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentPickupResponseModel {
    private long systemOrderId;

    @JsonProperty("pickup_status")
    private int pickupStatus;

    @JsonProperty("response")
    private Response response;

    @Getter
    @Setter
    public static class Response {
        @JsonProperty("pickup_scheduled_date")
        private String pickupScheduledDate;

        @JsonProperty("pickup_token_number")
        private String pickupTokenNumber;

        @JsonProperty("status")
        private int status;

        @JsonProperty("others")
        private String others;

        @JsonProperty("pickup_generated_date")
        private PickupGeneratedDate pickupGeneratedDate;

        @JsonProperty("data")
        private String data;
    }

    @Getter
    @Setter
    public static class PickupGeneratedDate {
        @JsonProperty("date")
        private String date;

        @JsonProperty("timezone_type")
        private int timezoneType;

        @JsonProperty("timezone")
        private String timezone;
    }
}