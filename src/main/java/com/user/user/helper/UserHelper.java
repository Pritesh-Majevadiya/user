package com.user.user.helper;

import com.user.user.entity.User;
import com.user.user.model.GetUserRequestDTO;
import com.user.user.model.GetUserResponseDTO;
import com.user.user.model.SaveUserRequestDTO;
import com.user.user.model.common.CommonResponse;
import com.user.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserHelper {

    @Autowired
    private UserService userService;
    public ResponseEntity<CommonResponse> createUser(SaveUserRequestDTO requestDTO) {
        if (ObjectUtils.isEmpty(requestDTO) || requestDTO.checkBadRequest()){
            log.info("Bad Request While Saving New User");
            return new ResponseEntity<>(new CommonResponse(HttpStatus.BAD_REQUEST.value(), "Required Data Not Found."), HttpStatus.BAD_REQUEST);
        }

        User user = userService.createUser(requestDTO);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(), "User Saved Successfully", user), HttpStatus.OK);
    }

    public ResponseEntity<CommonResponse> getAllUser(GetUserRequestDTO requestDTO) {
        if (ObjectUtils.isEmpty(requestDTO) || requestDTO.checkBadRequest()) {
            log.info("Bad Request While Get All User");
            return new ResponseEntity<>(new CommonResponse(HttpStatus.BAD_REQUEST.value(), "Required Data Not Found"), HttpStatus.BAD_REQUEST);
        }
        List<GetUserResponseDTO> user = userService.getAllUser(requestDTO);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(), "User Get Successfully", user), HttpStatus.OK);
    }


}
