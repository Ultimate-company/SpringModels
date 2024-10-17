package org.example.Translators.CentralDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CentralModels.ProductCategory;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface IProductCategorySubTranslator {
    /**
     * Gets all the root categories.
     * @return A response containing list of product categories.
     */
    Response<List<ProductCategory>> getRootCategories();

    /**
     * Gets all child categories given the parent id.
     * @param categoryId the category id
     * @return A response containing list of product categories.
     */
    Response<List<ProductCategory>> getChildCategoriesGivenParentId(long categoryId);

    /**
     * Get product category by name
     * @param name the category name
     * @return A response containing the product category.
     */
    Response<ProductCategory> getCategoryByName(String name);
}
