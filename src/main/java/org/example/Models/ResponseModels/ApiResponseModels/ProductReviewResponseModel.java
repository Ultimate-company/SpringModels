package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.CommunicationModels.CarrierModels.ProductReview;
import org.example.Models.CommunicationModels.CentralModels.User;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ProductReviewResponseModel {
    private Map<Long, ProductReview> productReviewMap;
    private Map<Long, List<Long>> productReviewTree;
    private long totalRootComments;
    private Map<Long, String> userIdFullNameMapping;

    // indiviual ProductReview
    private ProductReview productReview;
    private User user;
}
