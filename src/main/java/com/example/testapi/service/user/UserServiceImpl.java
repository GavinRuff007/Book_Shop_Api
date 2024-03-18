package com.example.testapi.service.user;

import com.example.testapi.dto.request.UserLoginRequest;
import com.example.testapi.dto.request.UserRequest;
import com.example.testapi.dto.response.UserResponse;
import com.example.testapi.exception.RuleException;
import com.example.testapi.model.User;
import com.example.testapi.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRep userRep;
    @Autowired
    public UserServiceImpl(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public UserResponse save(UserRequest user){
       Optional<User> byUsername =  userRep.findByUsername(user.getUsername());
        if(byUsername.isPresent())
            throw new RuleException("Username.is.Exist");

        return createUserResponse(userRep.save(createUserRequest(user)));
    }

    @Override
    public void login(UserLoginRequest userLoginRequest) {
       User user =  userRep.findByUsername(userLoginRequest.getUsername())
                .orElseThrow(() -> new RuleException("user.not.found"));
       if(!user.getPassword().equals(userLoginRequest.getPassword())){
           throw new RuleException("user.not.found");
       }
    }

    @Override
    public void changeEnable(Boolean enable, Long id) {
        User user = userRep.findById(id).orElseThrow(() -> new RuleException("user.not.found"));
        user.setEnabled(enable);
        userRep.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRep.findAll(pageable);
    }

    private UserResponse createUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    private User createUserRequest(UserRequest user){
       return User.builder()
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }
}
