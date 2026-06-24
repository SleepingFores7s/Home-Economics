package com.example.homeeconomics.economic.user.dto;

import com.example.homeeconomics.economic.validation.annotations.ValidPassword;
import com.example.homeeconomics.economic.validation.annotations.ValidUsernameOrEmail;
import jakarta.validation.constraints.NotBlank;

public class UserDeleteDto {

    @NotBlank
    @ValidUsernameOrEmail
    private String usernameOrEmail;

    @NotBlank
    @ValidPassword
    private String password;

    public UserDeleteDto() {}

    // Getter/Setter
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}