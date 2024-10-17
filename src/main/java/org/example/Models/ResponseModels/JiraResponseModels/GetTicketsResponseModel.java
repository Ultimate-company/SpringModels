package org.example.Models.ResponseModels.JiraResponseModels;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetTicketsResponseModel {
    private String expand;
    private int startAt;
    private int maxResults;
    private int total;
    private List<ResponseModelObjects.Issue> issues;
}
