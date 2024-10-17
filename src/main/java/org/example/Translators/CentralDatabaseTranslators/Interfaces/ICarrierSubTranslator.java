package org.example.Translators.CentralDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CentralModels.Carrier;
import org.example.Models.CommunicationModels.CentralModels.WebTemplateCarrierMapping;
import org.example.Models.RequestModels.GridRequestModels.GetCarriersRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.CarrierByWebTemplateWildCardResponse;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface ICarrierSubTranslator {

    /**
     * @summary Retrieves the details of a carrier by its ID.
     * Requires a valid authorization token.
     * @return Response containing carrier data if successful, otherwise error details.
     */
    Response<Carrier> getCarrierDetailsById(long carrierId);

    /**
     * @summary Checks if a user is mapped to a specific carrier.
     * Requires a valid authorization token.
     * @return Response containing true/false indicating mapping status, otherwise error details.
     */
    Response<Boolean> isUserMappedToCarrier();

    /**
     * @summary Retrieves carriers in batches based on provided criteria.
     * Requires a valid authorization token.
     * @param getCarriersRequestModel Request model containing filter and pagination details.
     * @return Response containing a paginated list of carriers if successful, otherwise error details.
     */
    Response<PaginationBaseResponseModel<Carrier>> getCarriersInBatches(GetCarriersRequestModel getCarriersRequestModel);

    /**
     * @summary Updates the API keys for a carrier.
     * Requires 'UPDATE_API_KEYS_PERMISSION' authorization.
     * @param carrier Carrier object containing updated API key details.
     * @return Response containing success or failure of the update operation.
     */
    Response<Boolean> updateApiKeys(Carrier carrier);

    /**
     * @summary Retrieves the API keys for the current carrier.
     * Requires 'VIEW_API_KEYS_PERMISSION' authorization.
     * @return Response containing carrier data with API key details, otherwise error details.
     */
    Response<Carrier> getApiKeys();

    /**
     * @summary Retrieves the carrier ID associated with a web template wildcard.
     * @param wildCard the wildcard of the website being accessed.
     * @return ResponseEntity containing the carrier if found, otherwise an error response.
     */
    Response<CarrierByWebTemplateWildCardResponse> getCarrierByWebTemplateWildCard(String wildCard);

    /**
     * @summary Retrieves token for web template website
     * @param webTemplateCarrierMapping the webtemplate api token being accessed
     * @return ResponseEntity containing the token, otherwise an error response.
     */
    Response<String> getTokenForWebTemplate(WebTemplateCarrierMapping webTemplateCarrierMapping);
}