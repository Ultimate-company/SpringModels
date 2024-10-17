package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class WebTemplatesFontStyle {
    private long webTemplateFontStyleId;
    private String fontStyle;
    private String fontColor;
    private double fontSize;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}

