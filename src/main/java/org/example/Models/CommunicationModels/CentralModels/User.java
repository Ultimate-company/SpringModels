package org.example.Models.CommunicationModels.CentralModels;

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
public class User {
    private Long userId;

    @IsRequired
    @FrontEndVariable

    private String loginName;
    private String password;
    private String salt;

    @IsRequired
    @FrontEndVariable
    private String firstName;

    @IsRequired
    @FrontEndVariable
    private String lastName;

    @IsRequired
    @FrontEndVariable
    private String phone;
    private Date datePasswordChanges;
    private int loginAttempts;

    @IsRequired
    @FrontEndVariable
    private String role;
    private boolean deleted;
    private boolean locked;
    private boolean emailConfirmed;
    private String token;

    @IsRequired
    @FrontEndVariable
    private Date dob;
    private boolean guest;
    private int lockedAttempts;
    private String apiKey;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private Long auditUserId;
}

