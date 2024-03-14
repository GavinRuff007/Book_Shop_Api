package com.example.testapi.controller;

import com.example.testapi.dto.request.UserRequest;
import com.example.testapi.dto.response.UserResponse;
import com.example.testapi.model.User;
import com.example.testapi.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Service
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
