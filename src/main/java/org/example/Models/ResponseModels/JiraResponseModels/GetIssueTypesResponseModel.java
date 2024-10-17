package org.example.Models.ResponseModels.JiraResponseModels;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetIssueTypesResponseModel{
    public String self;
    public String id;
    public String description;
    public String iconUrl;
    public String name;
    public String untranslatedName;
    public boolean subtask;
    public int avatarId;
    public int hierarchyLevel;
    public Scope scope;

    public static class Project{
        public String id;
    }

    public static class Scope{
        public Project project;
        public String type;
    }
}


