package com.example.homeeconomics.economic.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class RegisterUserDto {

    @NotBlank
    @Size(min = 8,max = 30, message = "Username must be between 8 and 30 characters long")
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    // Getter/Setter
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}