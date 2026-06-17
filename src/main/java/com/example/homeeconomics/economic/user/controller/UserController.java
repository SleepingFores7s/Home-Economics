package com.example.homeeconomics.economic.user.controller;

import com.example.homeeconomics.economic.user.dto.RegisterUserDto;
import com.example.homeeconomics.economic.user.dto.UserResponseDto;
import com.example.homeeconomics.economic.user.repository.UserRepository;
import com.example.homeeconomics.economic.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/user/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserDto dto) {

        UserResponseDto responseDto = userService.registerUser(dto);

        if (responseDto == null) {
            return ResponseEntity.badRequest().build();
        }else  {
            return ResponseEntity.ok(responseDto);
        }

    }

}
