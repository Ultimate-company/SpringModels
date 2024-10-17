package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import com.itextpdf.text.DocumentException;
import freemarker.template.TemplateException;
import org.example.Models.RequestModels.ApiRequestModels.PurchaseOrderRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.PurchaseOrderResponseModel;
import org.example.Models.ResponseModels.Response;

import java.io.IOException;

public interface IPurchaseOrderSubTranslator {
    /**
     * Retrieves Purchase Orders in batches based on the provided pagination criteria.
     *
     * @param paginationBaseRequestModel The pagination criteria for retrieving Purchase Orders.
     * @return A Response object containing a PaginationBaseResponseModel with Purchase Orders and pagination information.
     */
    Response<PaginationBaseResponseModel<PurchaseOrderResponseModel>> getPurchaseOrdersInBatches(PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Creates a new Purchase Order in the database.
     *
     * @param purchaseOrderRequestModel The request model containing Purchase Order details.
     * @return A Response object containing the ID of the newly created Purchase Order.
     */
    Response<Long> createPurchaseOrder(PurchaseOrderRequestModel purchaseOrderRequestModel);

    /**
     * Updates an existing Purchase Order in the database.
     *
     * @param purchaseOrderRequestModel The request model containing updated Purchase Order details.
     * @return A Response object containing the ID of the updated Purchase Order.
     */
    Response<Long> updatePurchaseOrder(PurchaseOrderRequestModel purchaseOrderRequestModel);

    /**
     * Retrieves a Purchase Order from the database by its ID.
     *
     * @param purchaseOrderId The ID of the Purchase Order to be retrieved.
     * @return A Response object containing a PurchaseOrderResponseModel with the details of the requested Purchase Order.
     */
    Response<PurchaseOrderResponseModel> getPurchaseOrderDetailsById(long purchaseOrderId);

    /**
     * Toggles the active state of a Purchase Order in the database.
     *
     * @param purchaseOrderId The ID of the Purchase Order to be toggled.
     * @return A Response object containing a boolean indicating the success of the toggle operation.
     */
    Response<Boolean> togglePurchaseOrder(long purchaseOrderId);

    /**
     * Sets user id of the approved user.
     *
     * @param purchaseOrderId The purchase order Id
     * @return A Response object containing a boolean indicating the success of the approved by operation.
     */
    Response<Boolean> approvedByPurchaseOrder(long purchaseOrderId);

    /**
     * Toggles the active state of a Sales Order in the database.
     *
     * @param purchaseOrderId The ID of the purcahse Order to be fetched.
     * @return A Response object containing a boolean indicating the success of the toggle operation.
     */
    Response<String> getPurchaseOrderPDF(long purchaseOrderId) throws TemplateException, IOException, DocumentException;
}
