package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;
import org.example.Models.CommunicationModels.CarrierModels.Product;

import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class ProductRequestModel {
    @FrontEndVariable
    @IsRequired
    private Product product;
    private Map<String, String> images;
}