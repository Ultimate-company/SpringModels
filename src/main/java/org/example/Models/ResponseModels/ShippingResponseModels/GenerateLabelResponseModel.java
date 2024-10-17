package org.example.Models.ResponseModels.ShippingResponseModels;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenerateLabelResponseModel {
    private int label_created;
    private String label_url;
    private String response;
    private String message;
    private Errors errors;
    private int status_code;

    @Getter
    @Setter
    private static class Errors {
        private List<String> shipment_id;
    }
}