package com.user.user.service;

import com.common_service.model.GetUserRequestDTO;
import com.common_service.model.GetUserResponseDTO;
import com.common_service.model.SaveUserRequestDTO;
import com.user.user.entity.User;

import java.util.List;

public interface UserService {


    User createUser(SaveUserRequestDTO requestDTO);

    List<GetUserResponseDTO> getAllUser(GetUserRequestDTO requestDTO);
}
