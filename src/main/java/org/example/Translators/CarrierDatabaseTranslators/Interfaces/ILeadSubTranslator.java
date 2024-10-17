package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.Lead;
import org.example.Models.RequestModels.ApiRequestModels.LeadRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.LeadResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.Response;

public interface ILeadSubTranslator {
    /**
     * Retrieves Leads in batches based on the provided pagination criteria.
     *
     * @param paginationBaseRequestModel The pagination criteria for retrieving Leads.
     * @return A PaginationBaseResponseModel containing Leads and pagination information.
     */
    Response<PaginationBaseResponseModel<LeadResponseModel>> getLeadsInBatches(PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Adds a new Lead to the database.
     *
     * @param leadRequestModel The Lead object to be added.
     * @return The ID of the newly created Lead.
     */
    Response<Long> createLead(LeadRequestModel leadRequestModel);

    /**
     * Updates an existing Lead in the database.
     *
     * @param leadRequestModel The Lead object containing the updated information.
     * @return the ID of the new updated lead.
     */
    Response<Long> updateLead(LeadRequestModel leadRequestModel);

    /**
     * Retrieves a Lead from the database by its ID.
     *
     * @param id The ID of the Lead to be retrieved.
     * @return A Lead object containing the details of the requested Lead.
     */
    Response<LeadResponseModel> getLeadDetailsById(long id);

    /**
     * Deletes a Lead from the database.
     *
     * @param id The ID of the Lead to be deleted.
     * @return True if the Lead deletion was successful, False otherwise.
     */
    Response<Boolean> toggleLead(long id);

    /**
     * Retrieves a Lead from the database by its email address.
     *
     * @param email The email address of the Lead to be retrieved.
     * @return A Lead object containing the details of the requested Lead.
     */
    Response<LeadResponseModel> getLeadDetailsByEmail(String email);
}
