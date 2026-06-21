package com.example.homeeconomics.economic.user.dto;

import com.example.homeeconomics.economic.validation.annotations.ValidPassword;
import com.example.homeeconomics.economic.validation.annotations.ValidUsername;
import com.example.homeeconomics.economic.validation.annotations.ValidUsernameOrEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLoginDto {

    @NotBlank
    @ValidUsernameOrEmail
    private String usernameOrEmail;

    @NotBlank
    @ValidPassword
    private String password;

    public UserLoginDto() {}


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
