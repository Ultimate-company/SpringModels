package org.example.Models.ResponseModels.JiraResponseModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateIssueTypeResponseModel{
    public int avatarId;
    public String description;
    public String entityId;
    public int hierarchyLevel;
    public String iconUrl;
    public String id;
    public String name;
    public Scope scope;
    public String self;
    public boolean subtask;

    @Getter
    @Setter
    public class AvatarUrls{
    }

    @Getter
    @Setter
    public class Project{
        public AvatarUrls avatarUrls;
        public String id;
        public String key;
        public String name;
        public ProjectCategory projectCategory;
        public String projectTypeKey;
        public String self;
        public boolean simplified;
    }

    @Getter
    @Setter
    public class ProjectCategory{
    }

    @Getter
    @Setter
    public class Scope{
        public Project project;
        public String type;
    }
}



