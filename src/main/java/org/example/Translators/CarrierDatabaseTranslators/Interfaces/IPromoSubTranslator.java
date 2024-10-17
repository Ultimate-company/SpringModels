package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.Promo;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;

public interface IPromoSubTranslator {
    /**
     * Retrieves promotion batches using pagination.
     *
     * @param paginationBaseRequestModel The pagination request model.
     * @return A response containing a batch of promotions.
     */
    Response<PaginationBaseResponseModel<Promo>> getPromosInBatches(PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Adds a new promotion.
     *
     * @param promo The promotion to add.
     * @return A response containing the ID of the added promotion.
     */
    Response<Long> createPromo(Promo promo);

    /**
     * Retrieves the details of a promotion by ID.
     *
     * @param promoId The ID of the promotion.
     * @return A response containing the promotion details.
     */
    Response<Promo> getPromoDetailsById(long promoId);

    /**
     * Toggles the delete status of a promotion.
     *
     * @param promoId   The ID of the promotion.
     * @return A response containing the ID of the promotion.
     */
    Response<Boolean> togglePromo(long promoId);

    /**
     * Retrieves the details of a promotion by name.
     *
     * @param promoCode The name of the promotion.
     * @return A response containing the promotion details.
     */
    Response<Promo> getPromoDetailsByName(String promoCode);
}
