package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class GridPreferenceRequestModel {
    private String density;
    private String visibilityJsonBody;
    private int rowsPerPage;
    private int gridId;
}