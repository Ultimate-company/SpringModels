package org.example.Models.ResponseModels.ShippingResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelShipmentResponseModel {
    @JsonProperty("message")
    private String message;
}
