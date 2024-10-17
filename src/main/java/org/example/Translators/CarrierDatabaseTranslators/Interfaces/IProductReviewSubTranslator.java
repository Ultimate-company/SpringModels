package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.ProductReview;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.ProductReviewResponseModel;
import org.example.Models.ResponseModels.Response;

public interface IProductReviewSubTranslator {
    /**
     * Adds a new product review to the system.
     *
     * @param productReview The review object containing details of the review.
     * @return A response containing the ID of the newly created review.
     */
    Response<Long> insertProductReview(ProductReview productReview);

    /**
     * Retrieves a paginated list of reviews for a specific product.
     *
     * @param paginationBaseRequestModel The model containing pagination information (e.g., page number, page size).
     * @param productId The ID of the product for which reviews are being retrieved.
     * @return A response containing a list of reviews for the specified product.
     */
    Response<ProductReviewResponseModel> getProductReviewsGivenProductId(PaginationBaseRequestModel paginationBaseRequestModel, long productId);

    /**
     * Toggles the visibility or status of a product review.
     *
     * @param id The ID of the review to be toggled.
     * @return A response indicating whether the toggle operation was successful.
     */
    Response<Boolean> toggleProductReview(long id);

    /**
     * Toggles the score of a product review
     *
     * @param reviewId The ID of the review to be toggled.
     * @param increaseScore Whether the score is to be increased or decreased.
     * @return A response indicating whether the toggle operation was successful.
     */
    Response<Boolean> toggleProductReviewScore(long reviewId, boolean increaseScore);

    /**
     * Delete product review
     *
     * @param reviewId The ID of the review to be deleted.
     * @return A response indicating whether the review was deleted or not.
     */
    Response<Boolean> deleteReview(long reviewId);

    /**
     * Get ProductReview By Id
     *
     * @param id The ID of the review to be fetched.
     * @return A response indicating whether the review was fetched or no.
     */
    Response<ProductReviewResponseModel> getProductReviewById(long id);
}
