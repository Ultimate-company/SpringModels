package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Models.RequestModels.ApiRequestModels.WebTemplateRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.WebTemplateResponseModel;
import org.example.Models.ResponseModels.Response;

public interface IWebTemplateSubTranslator {
    /**
     * Retrieves a web template by ID.
     *
     * @param webTemplateId The ID of the web template to retrieve.
     * @return A response containing the web template.
     */
    Response<WebTemplateResponseModel> getWebTemplateById(long webTemplateId);

    /**
     * Retrieves web templates in batches.
     *
     * @param paginationBaseRequestModel The request model for retrieving web templates.
     * @return A response containing a batch of web templates.
     */
    Response<PaginationBaseResponseModel<WebTemplateResponseModel>> getWebTemplatesInBatches(
            PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Inserts multiple web templates.
     *
     * @param webTemplateRequestModel The web templates to insert.
     * @return A response containing the IDs of the inserted web templates.
     */
    Response<Long> insertWebTemplate(WebTemplateRequestModel webTemplateRequestModel) throws JsonProcessingException;

    /**
     * Deactivates a web template by ID.
     *
     * @param webTemplateId The ID of the web template to deactivate.
     * @return A response indicating the success of the deactivation operation.
     */
    Response<Boolean> toggleWebTemplate(long webTemplateId);

    /**
     * Deploys a web template by ID.
     *
     * @param webTemplateId The ID of the web template to deploy.
     * @return A response indicating the success of the deployment operation.
     */
    Response<Boolean> deployWebTemplate(long webTemplateId);

    /**
     * Updates a web template.
     *
     * @param webTemplateRequestModel The web template to update.
     * @return A response containing the ID of the updated web template.
     */
    Response<Long> updateWebTemplate(WebTemplateRequestModel webTemplateRequestModel) throws JsonProcessingException;

    /**
     * Updates the user's cart associated with a web template.
     *
     * @param webTemplateRequestModel The request model containing the user cart information to update.
     * @return A response containing the ID of the updated cart entry.
     */
    Response<Long> updateUserCart(WebTemplateRequestModel webTemplateRequestModel);

    /**
     * Updates the user's liked items associated with a web template.
     *
     * @param webTemplateRequestModel The request model containing the liked items information to update.
     * @return A response containing the ID of the updated liked items entry.
     */
    Response<Long> updateUserLikedItems(WebTemplateRequestModel webTemplateRequestModel);
}