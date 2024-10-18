package org.example.Translators.CentralDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CentralModels.ProductCategory;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CentralDatabaseTranslators.Interfaces.IProductCategorySubTranslator;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.net.URLEncoder;


public class ProductCategorySubTranslator extends Translator implements IProductCategorySubTranslator {
    public ProductCategorySubTranslator(String token, Long auditUserId, Long carrierId, String apiUrl) {
        super(token, auditUserId, carrierId, apiUrl);
    }

    @Override
    public Response<List<ProductCategory>> getRootCategories() {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_CATEGORY + "/" + ApiRoutes.ProductCategorySubRoute.GET_ROOT_CATEGORIES),
                "GET",
                new TypeToken<Response<List<ProductCategory>>>(){}.getType(),
                null);
    }

    @Override
    public Response<List<ProductCategory>> getChildCategoriesGivenParentId(long categoryId) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_CATEGORY + "/" + ApiRoutes.ProductCategorySubRoute.GET_CHILD_CATEGORIES_GIVEN_PARENT_ID,
                        Collections.singletonMap("id", categoryId)),
                "GET",
                new TypeToken<Response<List<ProductCategory>>>(){}.getType(),
                null);
    }

    @Override
    public Response<ProductCategory> getCategoryByName(String name) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.PRODUCT_CATEGORY + "/" + ApiRoutes.ProductCategorySubRoute.GET_CATEGORY_BY_NAME,
                        Collections.singletonMap("name",  URLEncoder.encode(name, StandardCharsets.UTF_8))),
                "GET",
                new TypeToken<Response<ProductCategory>>(){}.getType(),
                null);
    }
}