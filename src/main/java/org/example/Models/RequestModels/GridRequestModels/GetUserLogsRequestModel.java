package org.example.Models.RequestModels.GridRequestModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserLogsRequestModel extends PaginationBaseRequestModel {
    private long userId;
    private long carrierId;
}
