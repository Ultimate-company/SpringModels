package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.Annotations.FrontEndVariable;
import org.example.Annotations.IsRequired;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class Message {
    private Long messageId;

    @FrontEndVariable
    @IsRequired
    private String title;

    @FrontEndVariable
    @IsRequired
    private Date publishDate;

    @FrontEndVariable
    @IsRequired
    private String description;

    @FrontEndVariable
    @IsRequired
    private String descriptionHtml;

    @FrontEndVariable
    @IsRequired
    private boolean sendAsEmail;
    private boolean deleted;
    private boolean updated;
    private Long createdByUserId;
    private String sendgridEmailBatchId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @FrontEndVariable
    private String notes;
    private Long auditUserId;
}
