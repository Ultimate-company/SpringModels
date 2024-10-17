package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest
{
    private Long id;
    private Long userId;
    private Long carrierId;
    private boolean includeDeleted;
}