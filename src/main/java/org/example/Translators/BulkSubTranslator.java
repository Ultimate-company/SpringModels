package org.example.Translators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.ResponseModels.ApiResponseModels.GetCarrierResponseModel;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.Interface.IBulkSubTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BulkSubTranslator extends Translator implements IBulkSubTranslator {
    public BulkSubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<Boolean> bulkAdd(String bulkAddType, Object object) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("type", bulkAddType);

        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.BULK + "/" + ApiRoutes.BulkSubRoute.BULK_INSERT,
                        params),
                "PUT",
                new TypeToken<Response<Boolean>>(){}.getType(),
                object);
    }

    @Deprecated
    @Override
    public CompletableFuture<Response<Boolean>> bulkAddAsync(String bulkAddType,
                                                             String object,
                                                             String auditUserId,
                                                             String carrierId,
                                                             String token) throws Exception {
        return null;
    }
}
