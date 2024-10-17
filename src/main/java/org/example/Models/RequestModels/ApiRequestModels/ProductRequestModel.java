package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.Product;

import java.util.Map;

@Getter
@Setter
public class ProductRequestModel {
    private Product product;
    private Map<String, String> images;
}