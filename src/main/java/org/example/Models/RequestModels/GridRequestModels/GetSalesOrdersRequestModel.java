package org.example.Models.RequestModels.GridRequestModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.Enums.SalesOrderStatus;

import java.util.List;

@Getter
@Setter
public class GetSalesOrdersRequestModel extends PaginationBaseRequestModel {
    private List<SalesOrderStatus> salesOrderStatus;
}
