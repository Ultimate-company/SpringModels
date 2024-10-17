package org.example.Models.ResponseModels.JiraResponseModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class CreateAttachmentResponseModel {
    private String self;
    private String id;
    private String filename;
    private ResponseModelObjects.Author author;
    private Date created;
    private int size;
    private String mimeType;
    private String content;
    private String thumbnail;
}