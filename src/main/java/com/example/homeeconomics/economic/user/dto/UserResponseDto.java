package com.example.homeeconomics.economic.user.dto;

import java.sql.Date;

public record UserResponseDto(
        String username,
        String email,
        Date createdAt,
        Date updatedAt) {
}
