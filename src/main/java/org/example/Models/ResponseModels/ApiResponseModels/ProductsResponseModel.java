package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.PickupLocation;
import org.example.Models.CommunicationModels.CarrierModels.Product;
import org.example.Models.CommunicationModels.CentralModels.ProductCategory;

import java.util.Map;

@Getter
@Setter
public class ProductsResponseModel {
    private Product product;
    private ProductCategory productCategory;
    private PickupLocationResponseModel pickupLocationResponseModel;
    private Map<String, String> imageBase64Mapping;

    // fields to be used by webTemplate
    private double productRating;
    private long totalProductReviews;
    private long numberOfCarts;
    private long numberOfLikedItems;
    private long quantityInCurrentUsersCart;
    private boolean productInLikedItemsForCurrentUser;
}
