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

    /**
     * Retrieve a list of product categories that do not have any children.
     *
     * This method identifies product categories whose `id` does not appear as a
     * `parentId` in any other product category, effectively finding all leaf or standalone
     * categories in the hierarchy.
     *
     * @return A response containing a list of product categories without children.
     */
    Response<List<ProductCategory>> findCategoriesWithoutChildren();
}
