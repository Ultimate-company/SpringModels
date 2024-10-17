package org.example.Models.ResponseModels.ApiResponseModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.ResponseModels.JiraResponseModels.ResponseModelObjects;

import java.util.Date;

@Getter
@Setter
public class GetAttachmentMetadataResponseModel {
    public ResponseModelObjects.Author author;
    public String content;
    public Date created;
    public String filename;
    public int id;
    public String mimeType;
    public String self;
    public int size;
    public String thumbnail;
}