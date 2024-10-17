package org.example.Models.ResponseModels.JiraResponseModels;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetCommentsResponseModel {
    private int startAt;
    private int maxResults;
    private int total;
    private List<ResponseModelObjects.Comment> comments;
}
