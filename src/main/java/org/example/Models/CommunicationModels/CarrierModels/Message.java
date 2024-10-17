package org.example.Models.CommunicationModels.CarrierModels;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Message {
    private Long messageId;
    private String title;
    private Date publishDate;
    private String description;
    private String descriptionMarkDown;
    private String descriptionHtml;
    private boolean sendAsEmail;
    private boolean deleted;
    private boolean updated;
    private long createdByUserId;
    private String sendgridEmailBatchId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
