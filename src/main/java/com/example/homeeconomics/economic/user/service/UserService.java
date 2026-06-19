package com.example.homeeconomics.economic.user.service;

import com.example.homeeconomics.economic.user.dto.RegisterUserDto;
import com.example.homeeconomics.economic.user.dto.UserLoginDto;
import com.example.homeeconomics.economic.user.dto.UserResponseDto;
import com.example.homeeconomics.economic.user.entity.User;
import com.example.homeeconomics.economic.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto registerUser(RegisterUserDto dto) {

        return new UserResponseDto(userRepository.save(
                new User(
                        dto.getUsername(),
                        dto.getEmail(),
                        passwordEncoder.encode(dto.getPassword()
                        )
                )
        ));
    }

    public UserResponseDto login(UserLoginDto userLoginDto) {

        //TODO make a check if the username exists, then if the password matches and return responseDto
    }

}
