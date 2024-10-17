package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.ProductReview;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.ProductReviewResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.IProductReviewSubTranslator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductReviewSubTranslator extends Translator implements IProductReviewSubTranslator {
    public ProductReviewSubTranslator(String token, Long auditUserId, Long carrierId) {
        super(token, auditUserId, carrierId);
    }

    @Override
    public Response<Long> insertProductReview(ProductReview productReview) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_REVIEW + "/" + ApiRoutes.ProductReviewSubRoute.INSERT_PRODUCT_REVIEW),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                productReview);
    }

    @Override
    public Response<ProductReviewResponseModel> getProductReviewsGivenProductId(PaginationBaseRequestModel paginationBaseRequestModel, long productId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_REVIEW + "/" + ApiRoutes.ProductReviewSubRoute.GET_PRODUCT_REVIEWS_GIVEN_PRODUCT_ID,
                        Collections.singletonMap("id", productId)),
                "POST",
                new TypeToken<Response<ProductReviewResponseModel>>(){}.getType(),
                paginationBaseRequestModel);
    }

    @Override
    @Deprecated(since = "Use delete review")
    public Response<Boolean> toggleProductReview(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_REVIEW + "/" + ApiRoutes.ProductReviewSubRoute.TOGGLE_PRODUCT_REVIEW,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> toggleProductReviewScore(long reviewId, boolean increaseScore) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", reviewId);
        params.put("increaseScore", increaseScore);

        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_REVIEW + "/" + ApiRoutes.ProductReviewSubRoute.TOGGLE_PRODUCT_REVIEW_SCORE,
                        params),
                "POST",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> deleteReview(long reviewId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_REVIEW + "/" + ApiRoutes.ProductReviewSubRoute.TOGGLE_PRODUCT_REVIEW,
                        Collections.singletonMap("id", reviewId)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<ProductReviewResponseModel> getProductReviewById(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_REVIEW + "/" + ApiRoutes.ProductReviewSubRoute.GET_PRODUCT_REVIEW_BY_ID,
                        Collections.singletonMap("id", id)),
                "GET",
                new TypeToken<Response<ProductReviewResponseModel>>(){}.getType(),
                null);
    }
}
