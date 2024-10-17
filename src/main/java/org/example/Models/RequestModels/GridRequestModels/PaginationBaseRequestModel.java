package org.example.Models.RequestModels.GridRequestModels;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginationBaseRequestModel {
    private int start;
    private int end;
    private String condition;
    private String filterExpr;
    private String columnName;
    private int pageSize;
    private boolean includeDeleted;
    private boolean includeExpired;
    private List<Long> selectedIds;
}
