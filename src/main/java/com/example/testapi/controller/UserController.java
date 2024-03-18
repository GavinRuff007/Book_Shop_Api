package com.example.testapi.controller;

import com.example.testapi.dto.request.UserLoginRequest;
import com.example.testapi.dto.request.UserRequest;
import com.example.testapi.dto.response.UserResponse;
import com.example.testapi.model.User;
import com.example.testapi.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
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

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        userService.login(userLoginRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/enabled/{id}/{enable}")
    public ResponseEntity<?> changeEnableUser(@PathVariable Boolean enable,@PathVariable Long id){
        userService.changeEnable(enable,id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUser(Pageable pageable){
        return ResponseEntity.ok(userService.findAll(pageable));
    }
}
