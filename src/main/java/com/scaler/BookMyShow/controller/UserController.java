package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.dto.UserLoginRequestDTO;
import com.scaler.BookMyShow.dto.UserSignUpRequestDTO;
import com.scaler.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO loginRequestDTO){

        return ResponseEntity.ok(userService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO signUpRequestDTO){
        return ResponseEntity.ok(userService.signUp(signUpRequestDTO.getName(), signUpRequestDTO.getEmail(),
                signUpRequestDTO.getPassword()));
    }
}
