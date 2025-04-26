package com.user.user.service;

import com.user.user.entity.User;
import com.user.user.model.SaveUserRequestDTO;
import com.user.user.serviceImpl.UserServiceImpl;

public interface UserService {


    User createUser(SaveUserRequestDTO requestDTO);
}
