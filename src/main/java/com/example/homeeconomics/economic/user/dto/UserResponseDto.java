package com.example.homeeconomics.economic.user.dto;

import java.time.LocalDateTime;

public record UserResponseDto(
        String username,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
