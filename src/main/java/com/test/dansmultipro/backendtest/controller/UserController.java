package com.test.dansmultipro.backendtest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.dansmultipro.backendtest.dto.LoginRequest;
import com.test.dansmultipro.backendtest.service.UserService;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
        if (userService.isValidLogin(request.getUsername(), request.getPassword())) {
            return ResponseEntity.ok("valid");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("login not found");
        }
    }
}
