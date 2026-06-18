package com.example.homeeconomics.economic.user.dto;

import com.example.homeeconomics.economic.user.entity.User;

import java.time.LocalDateTime;

public record UserResponseDto(
        String username,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt)
{
    public UserResponseDto(User user) {
        this(user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
