package com.example.testapi.service.user;

import com.example.testapi.dto.request.UserLoginRequest;
import com.example.testapi.dto.request.UserRequest;
import com.example.testapi.dto.response.UserResponse;
import com.example.testapi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse save(UserRequest user);

    void login(UserLoginRequest userLoginRequest);

    void changeEnable(Boolean enable, Long id);

    Page<User> findAll(Pageable pageable);
}
