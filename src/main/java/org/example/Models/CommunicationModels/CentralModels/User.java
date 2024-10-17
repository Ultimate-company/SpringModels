package org.example.Models.CommunicationModels.CentralModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class User {
    private long userId;
    private String loginName;
    private String password;
    private String salt;
    private String firstName;
    private String lastName;
    private String phone;
    private Date datePasswordChanges;
    private int loginAttempts;
    private String role;
    private boolean deleted;
    private boolean locked;
    private boolean emailConfirmed;
    private String token;
    private String avatar;
    private Date dob;
    private boolean guest;
    private int lockedAttempts;
    private String apiKey;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}

