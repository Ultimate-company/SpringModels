package org.example.Models.CommunicationModels.CentralModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class WebTemplateCarrierMapping {
    private Long webTemplateCarrierMappingId;
    private String wildCard;
    private String apiAccessKey;

    // Tracking Fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;

    // mapping Fields
    private Long webTemplateId;
    private Long carrierId;
}