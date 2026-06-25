package com.example.homeeconomics.economic.user.dto;

import com.example.homeeconomics.economic.validation.annotations.ValidPassword;
import com.example.homeeconomics.economic.validation.annotations.ValidUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserUpdateDto {

    @ValidUsername
    private String username;

    @ValidPassword
    private String currentPassword;

    @ValidPassword
    private String newPassword;

    @Email
    private String email;

    public UserUpdateDto() {}

    public String getUsername() {
        return username;
    }
    public String getCurrentPassword() {
        return currentPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public String getEmail() {
        return email;
    }

}
