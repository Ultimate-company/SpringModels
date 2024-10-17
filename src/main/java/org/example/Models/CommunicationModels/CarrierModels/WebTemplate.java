package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class WebTemplate {
    private long webTemplateId;
    private String sortOptions;
    private String selectedProducts;
    private String filterOptions;
    private String stateCitiesMapping;
    private String acceptedPaymentOptions;
    private String url;
    private boolean deleted;
    private long cardHeaderFontStyleId;
    private long cardSubTextFontStyleId;
    private long headerFontStyleId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
