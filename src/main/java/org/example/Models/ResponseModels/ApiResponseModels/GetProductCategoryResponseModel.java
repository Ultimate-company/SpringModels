package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.CommonHelpers.ProductHelper;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GetProductCategoryResponseModel {
    private List<String> allParents;
    private List<ProductHelper.ProductCategory> productCategories;
    private String selectedText;
    private boolean isEnd;
}
