package org.example.Translators.Interface;

import org.example.Models.ResponseModels.Response;

import java.util.concurrent.CompletableFuture;

public interface IBulkSubTranslator {
    /**
     * Bulk adds data of a specified type.
     *
     * @param bulkAddType the type of data to be added (e.g., "users", "orders").
     * @param object      the object containing the data to be added, which can be in various formats.
     * @return a Response containing a Boolean indicating the success of the operation.
     * @throws Exception if an error occurs during the bulk add process.
     */
    Response<Boolean> bulkAdd(String bulkAddType, Object object) throws Exception;
    /**
     * Bulk adds data of a specified type.
     *
     * @param bulkAddType the type of data to be added (e.g., "users", "orders").
     * @param object      the object containing the data to be added, which can be in various formats.
     * @return a Response containing a Boolean indicating the success of the operation.
     * @throws Exception if an error occurs during the bulk add process.
     */
    CompletableFuture<Response<Boolean>> bulkAddAsync(
            String bulkAddType,
            String object,
            String auditUserId,
            String carrierId,
            String token) throws Exception;
}
