package com.user.user.controller;

import com.user.user.helper.UserHelper;
import com.user.user.model.GetUserRequestDTO;
import com.user.user.model.SaveUserRequestDTO;
import com.user.user.model.common.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserHelper userHelper;

    @PostMapping("/create-user")
    private ResponseEntity<CommonResponse> createUser(@RequestBody SaveUserRequestDTO requestDTO){
        try{
           return userHelper.createUser(requestDTO);
        }catch (Exception exception){
            throw new RuntimeException();
        }
    }

    @PostMapping("/get-all")
    private ResponseEntity<CommonResponse> getAllUser(@RequestBody GetUserRequestDTO requestDTO){
        try {
            return userHelper.getAllUser(requestDTO);
        }catch (Exception exception){
            throw new RuntimeException();
        }
    }


}
