package com.example.homeeconomics.economic.user.service;

import com.example.homeeconomics.economic.user.dto.*;
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

        User user = getUserByLoginIdentifier(userLoginDto.getUsernameOrEmail());

        if (user == null || !passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username/email or password");
        }

        return new UserResponseDto(user);

    }

    public UserResponseDto update(Long id, UserUpdateDto dto) {

        User existingUser = userRepository.getReferenceById(id);

        if (!passwordEncoder.matches(dto.getCurrentPassword(), existingUser.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        if (dto.getUsername() != null) {
            existingUser.setUsername(dto.getUsername());
        }
        if (dto.getNewPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        }
        if (dto.getEmail() != null) {
            existingUser.setEmail(dto.getEmail());
        }

        return new UserResponseDto(userRepository.save(existingUser));


    }

    public void deleteUser(Long id, UserDeleteDto deleteDto) {

        User user = userRepository.getReferenceById(id);

        if (passwordEncoder.matches(deleteDto.getPassword(), user.getPassword())) {
            userRepository.delete(user);
        } else {
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
