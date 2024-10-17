package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductReview {
    private Long reviewId;
    private double ratings;
    private int score;
    private boolean isDeleted;
    private String review;
    private long userId;
    private long productId;
    private Long parentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
