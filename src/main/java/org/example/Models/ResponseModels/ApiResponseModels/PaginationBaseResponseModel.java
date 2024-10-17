package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PaginationBaseResponseModel<T> {
    private List<T> data;
    private long totalDataCount;
}
