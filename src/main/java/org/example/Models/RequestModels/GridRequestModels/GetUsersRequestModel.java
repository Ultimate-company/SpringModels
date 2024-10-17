package org.example.Models.RequestModels.GridRequestModels;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetUsersRequestModel extends PaginationBaseRequestModel{
    private List<Long> selectedUsers;
}
