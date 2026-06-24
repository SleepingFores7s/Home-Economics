package com.example.homeeconomics.economic.user.service;

import com.example.homeeconomics.economic.user.dto.UserDeleteDto;
import com.example.homeeconomics.economic.user.dto.UserRegisterDto;
import com.example.homeeconomics.economic.user.dto.UserLoginDto;
import com.example.homeeconomics.economic.user.dto.UserResponseDto;
import com.example.homeeconomics.economic.user.entity.User;
import com.example.homeeconomics.economic.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto registerUser(UserRegisterDto dto) {

        User existingUser = userRepository.findByUsername(dto.getUsername());

        if (existingUser != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "User already exists!"
            );
        }

        User newUser = new User(
                dto.getUsername(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()
                )
        );

        return new UserResponseDto(userRepository.save(newUser));
    }

    public UserResponseDto login(UserLoginDto userLoginDto) {

        String userInput = userLoginDto.getUsernameOrEmail();

        User user = getUserByLoginIdentifier(userInput);

        if (user == null || !passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username/email or password");
        }

        return new UserResponseDto(user);

    }

    public void deleteUser(UserDeleteDto deleteDto) {

        String userInput = deleteDto.getUsernameOrEmail();

        User user = getUserByLoginIdentifier(userInput);

        if (passwordEncoder.matches(deleteDto.getPassword(), user.getPassword())) {
            userRepository.delete(user);
        }else {
            throw new BadCredentialsException("Invalid username/email or password");
        }
    }

    public User getUserByLoginIdentifier(String emailOrUsername) {
        if (emailOrUsername.contains("@")) {
            return userRepository.findByEmail(emailOrUsername);
        } else {
            return userRepository.findByUsername(emailOrUsername);
        }
    }

}
