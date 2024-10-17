package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.Product;
import org.example.Models.RequestModels.ApiRequestModels.ProductRequestModel;
import org.example.Models.RequestModels.GridRequestModels.PaginationBaseRequestModel;
import org.example.Models.ResponseModels.ApiResponseModels.PaginationBaseResponseModel;
import org.example.Models.ResponseModels.ApiResponseModels.ProductsResponseModel;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface IProductSubTranslator {
    /**
     * Adds a new product.
     *
     * @param product The product and images to add.
     * @return A response containing the ID of the added product.
     */
    Response<Long> addProduct(Product product);

    /**
     * Edits an existing product.
     *
     * @param product The product to edit.
     * @return A response containing the ID of the edited product.
     */
    Response<Long> editProduct(Product product);

    /**
     * Toggles the delete status of a product.
     *
     * @param productId The ID of the product.
     * @return A response containing the ID of the product.
     */
    Response<Boolean> toggleDeleteProduct(long productId);

    /**
     * Toggles the return status of a product.
     *
     * @param productId The ID of the product.
     * @return A response containing the ID of the product.
     */
    Response<Boolean> toggleReturnProduct(long productId);

    /**
     * Retrieves the details of a product.
     *
     * @param productId The ID of the product.
     * @return A response containing the product details.
     */
    Response<ProductsResponseModel> getProductDetailsById(long productId);

    /**
     * Retrieves product batches in a carrier using pagination.
     *
     * @param paginationBaseRequestModel The pagination request model.
     * @return A response containing a batch of products in the carrier.
     */
    Response<PaginationBaseResponseModel<ProductsResponseModel>> getProductInBatches(PaginationBaseRequestModel paginationBaseRequestModel);

    /**
     * Retrieves the details of a product.
     *
     * @param productIds The IDs of the product.
     * @return A response containing the product details.
     */
    Response<List<ProductsResponseModel>> getProductDetailsByIds(List<Long> productIds);

    // Public endpoints
    Response<PaginationBaseResponseModel<ProductsResponseModel>> getProductInBatches_Public(PaginationBaseRequestModel paginationBaseRequestModel);

    Response<List<ProductsResponseModel>> getProductDetailsByIds_Public(List<Long> productIds);

    Response<ProductsResponseModel> getProductDetailsById_Public(long productId);
}
