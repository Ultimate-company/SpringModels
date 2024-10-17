package org.example.Models.CommunicationModels.CentralModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GoogleUser {
    private long userId;
    private String accessToken;
    private String googleId;
    private String imageUrl;
    private String tokenId;
    private String email;
    private String familyName;
    private String givenName;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}
