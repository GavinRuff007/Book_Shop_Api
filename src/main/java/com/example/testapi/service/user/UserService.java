package com.example.testapi.service.user;

import com.example.testapi.dto.request.UserRequest;
import com.example.testapi.dto.response.UserResponse;
import com.example.testapi.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse save(UserRequest user);
}
