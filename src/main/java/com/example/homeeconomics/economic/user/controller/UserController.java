package com.example.homeeconomics.economic.user.controller;

import com.example.homeeconomics.economic.user.dto.UserDeleteDto;
import com.example.homeeconomics.economic.user.dto.UserRegisterDto;
import com.example.homeeconomics.economic.user.dto.UserLoginDto;
import com.example.homeeconomics.economic.user.dto.UserResponseDto;
import com.example.homeeconomics.economic.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/user/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDto userLoginDto) {
        try{
            UserResponseDto responseDto = userService.login(userLoginDto);
            return ResponseEntity
                    .ok(responseDto);

        }catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    @PostMapping("api/user/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDto dto) {

        UserResponseDto responseDto = userService.registerUser(dto);

        if (responseDto == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }else  {
            return ResponseEntity
                    .ok(responseDto);
        }
    }

    @DeleteMapping("/api/user/delete")
    public ResponseEntity<?> deleteUser(@Valid @RequestBody UserDeleteDto dto) {
        try {
            userService.deleteUser(dto);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

}
