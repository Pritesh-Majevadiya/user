package com.user.user.serviceImpl;

import com.user.user.entity.User;
import com.user.user.model.SaveUserRequestDTO;
import com.user.user.repository.UserRepository;
import com.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(SaveUserRequestDTO requestDTO) {
       User user = User.builder()
               .firstName(requestDTO.getFirstName())
               .lastName(requestDTO.getLastName())
               .middleName(requestDTO.getMiddleName())
               .personalMail(requestDTO.getPersonalMail())
               .primaryMobileNo(requestDTO.getPrimaryMobileNo())
               .secondaryMobileNo(requestDTO.getSecondaryMobileNo())
               .cretedDate(new Date())
               .isActive(Boolean.TRUE)
               .isDeleted(Boolean.FALSE)
               .build();
        return userRepository.save(user);
    }
}
