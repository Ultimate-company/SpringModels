package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;

import java.time.LocalDateTime;

@Getter
@Setter
public class WebTemplatesFontStyle {
    private long webTemplateFontStyleId;

    @FrontEndVariable
    @IsRequired
    private String fontStyle;

    @FrontEndVariable
    @IsRequired
    private String fontColor;

    @FrontEndVariable
    @IsRequired
    private double fontSize;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}

