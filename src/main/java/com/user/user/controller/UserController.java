package com.user.user.controller;

import com.user.user.entity.User;
import com.user.user.helper.UserHelper;
import com.user.user.model.CommonResponse;
import com.user.user.model.SaveUserRequestDTO;
import com.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserHelper userHelper;
    @PostMapping
    private ResponseEntity<CommonResponse> createUser(@RequestBody SaveUserRequestDTO requestDTO){
        try{
           return userHelper.createUser(requestDTO);
        }catch (Exception exception){
            throw new RuntimeException();
        }
    }
}
