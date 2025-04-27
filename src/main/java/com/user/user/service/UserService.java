package com.user.user.service;

import com.user.user.entity.User;
import com.user.user.model.GetUserRequestDTO;
import com.user.user.model.GetUserResponseDTO;
import com.user.user.model.SaveUserRequestDTO;
import com.user.user.serviceImpl.UserServiceImpl;

import java.util.List;

public interface UserService {


    User createUser(SaveUserRequestDTO requestDTO);

    List<GetUserResponseDTO> getAllUser(GetUserRequestDTO requestDTO);
}
