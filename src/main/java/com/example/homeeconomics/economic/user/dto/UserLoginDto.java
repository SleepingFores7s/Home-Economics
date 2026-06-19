package com.example.homeeconomics.economic.user.dto;

import com.example.homeeconomics.economic.validation.annotations.ValidPassword;
import com.example.homeeconomics.economic.validation.annotations.ValidUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLoginDto {

    @NotBlank
    @ValidUsername
    private String username;

    @NotBlank
    @ValidPassword
    private String password;

    @NotBlank
    @Email(message = "Email format not correct")
    private String email;

    public UserLoginDto() {}


    // Getter/Setter
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
