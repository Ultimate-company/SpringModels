package org.example.Models.ResponseModels.JiraResponseModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class AddCommentResponseModel {
    private String self;
    private String id;
    private ResponseModelObjects.Author author;
    private ResponseModelObjects.Body body;
    private ResponseModelObjects.UpdateAuthor updateAuthor;
    private Date created;
    private Date updated;
    private ResponseModelObjects.Visibility visibility;
}
