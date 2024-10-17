package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import com.itextpdf.text.DocumentException;
import freemarker.template.TemplateException;
import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.RequestModels.ApiRequestModels.SalesOrderRequestModel;
import org.example.Models.RequestModels.GridRequestModels.GetSalesOrdersRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.SalesOrderResponseModel;
import org.example.Models.ResponseModels.Response;

import java.io.IOException;

public interface ISalesOrderSubTranslator {
    /**
     * Retrieves Sales Orders in batches based on the provided pagination criteria.
     *
     * @param getSalesOrdersRequestModel The pagination criteria for retrieving Sales Orders.
     * @return A Response object containing a PaginationBaseResponseModel with Sales Orders and pagination information.
     */
    Response<PaginationBaseResponseModel<SalesOrderResponseModel>> getSalesOrdersInBatches(GetSalesOrdersRequestModel getSalesOrdersRequestModel);

    /**
     * Creates a new Sales Order in the database.
     *
     * @param salesOrderRequestModel The request model containing Sales Order details.
     * @return A Response object containing the ID of the newly created Sales Order.
     */
    Response<Long> createSalesOrder(SalesOrderRequestModel salesOrderRequestModel) throws Exception;

    /**
     * Updates an existing Sales Order in the database.
     *
     * @param salesOrderRequestModel The request model containing updated Sales Order details.
     * @return A Response object containing the ID of the updated Sales Order.
     */
    Response<Long> updateSalesOrder(SalesOrderRequestModel salesOrderRequestModel);

    /**
     * Retrieves a Sales Order from the database by its ID.
     *
     * @param salesOrderId The ID of the Sales Order to be retrieved.
     * @return A Response object containing a SalesOrderResponseModel with the details of the requested Sales Order.
     */
    Response<SalesOrderResponseModel> getSalesOrderDetailsById(long salesOrderId);

    /**
     * Toggles the active state of a Sales Order in the database.
     *
     * @param salesOrderId The ID of the Sales Order to be toggled.
     * @return A Response object containing a boolean indicating the success of the toggle operation.
     */
    Response<Boolean> toggleSalesOrder(long salesOrderId);

    /**
     * Toggles the active state of a Sales Order in the database.
     *
     * @param salesOrderId The ID of the Sales Order to be fetched.
     * @return A Response object containing a boolean indicating the success of the toggle operation.
     */
    Response<byte[]> getSalesOrderPDF(long salesOrderId) throws TemplateException, IOException, DocumentException;


    /**
     * Cancel sales order
     * @param salesOrderId The ID of the Sales Order to be cancelled.
     * @return A Response object containing a boolean indicating the success of the cancel operation.
     */
    Response<Boolean> cancelSalesOrder(long salesOrderId);

    /**
     * Updates the shipping address for a given sales order
     * @param salesOrderId The ID of the Sales Order to be updated.
     * @param address The new address that wants to be updated on the sales order.
     * @return A Response object containing a boolean indicating the success of the update operation.
     */
    Response<Boolean> updateCustomerDeliveryAddress(long salesOrderId, Address address);

    /**
     * updated the pickup order for the given shipRocket order Id
     * @param salesOrderId The ID of the Sales Order to be updated.
     * @param shipRocketOrderId The shipRocket id that needs to be updated
     * @param pickupLocationId The new pickup location
     * @return A Response object containing a boolean indicating the success of the update operation.
     */
    Response<Boolean> updateSalesOrderPickupAddress(long salesOrderId, long shipRocketOrderId, long pickupLocationId);
}
