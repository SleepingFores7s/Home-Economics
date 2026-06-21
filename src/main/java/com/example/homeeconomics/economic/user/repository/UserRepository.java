package com.example.homeeconomics.economic.user.repository;

import com.example.homeeconomics.economic.user.dto.UserResponseDto;
import com.example.homeeconomics.economic.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    UserResponseDto getUserByUsername(String username);

    UserResponseDto getUserByEmail(String email);

    User findByEmail(String email);

    User findByUsername(String username);
}
