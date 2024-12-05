package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class WebTemplate {
    private Long webTemplateId;
    private String sortOptions;
    private String selectedProducts;
    private String filterOptions;
    private String stateCitiesMapping;
    private String acceptedPaymentOptions;

    @FrontEndVariable
    @IsRequired
    private String url;
    private boolean deleted;
    private long cardHeaderFontStyleId;
    private long cardSubTextFontStyleId;
    private long headerFontStyleId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}
