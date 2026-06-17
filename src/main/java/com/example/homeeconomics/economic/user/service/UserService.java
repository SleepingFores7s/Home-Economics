package com.example.homeeconomics.economic.user.service;

import com.example.homeeconomics.economic.user.dto.RegisterUserDto;
import com.example.homeeconomics.economic.user.dto.UserResponseDto;
import com.example.homeeconomics.economic.user.entity.User;
import com.example.homeeconomics.economic.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto registerUser(RegisterUserDto dto) {

        User user = userRepository.save(new User(
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword()
        ));

        return new UserResponseDto(
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

}
