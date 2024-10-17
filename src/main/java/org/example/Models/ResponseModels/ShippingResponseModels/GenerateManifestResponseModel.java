package org.example.Models.ResponseModels.ShippingResponseModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateManifestResponseModel {
    private int status;
    private String manifest_url;
    private String message;
}
