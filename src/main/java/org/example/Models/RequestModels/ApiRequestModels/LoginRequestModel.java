package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestModel extends BaseRequest {
    private String loginName;
    private String password;
    private String apiKey;
    private String token;
    private String phone;
    private String firstName;
    private String lastName;
    private String confirmPassword;
    private String dob;
    private String role;
    private Boolean isTermsAndConditions;
}
