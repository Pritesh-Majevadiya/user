package com.user.user.serviceImpl;

import com.common_service.model.GetUserRequestDTO;
import com.common_service.model.GetUserResponseDTO;
import com.common_service.model.SaveUserRequestDTO;
import com.user.user.entity.User;
import com.user.user.repository.UserRepository;
import com.user.user.service.UserService;
import com.user.user.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(SaveUserRequestDTO requestDTO) {
        User user = User.builder()
                .firstName(requestDTO.getFirstName())
                .middleName(requestDTO.getMiddleName())
                .lastName(requestDTO.getLastName())
                .personalMail(requestDTO.getPersonalMail())
                .primaryMobileNo(requestDTO.getPrimaryMobileNo())
                .secondaryMobileNo(requestDTO.getSecondaryMobileNo())
                .cretedDate(new Date())
                .isActive(Boolean.TRUE)
                .isDeleted(Boolean.FALSE)
                .build();
        return userRepository.save(user);
    }

    @Override
    public List<GetUserResponseDTO> getAllUser(GetUserRequestDTO requestDTO) {
        Specification<User> specification = Specification.where(UserSpecification.hasFirstName(requestDTO.getFirstName())
                .and(UserSpecification.hasMiddleName(requestDTO.getMiddleName()))
                .and(UserSpecification.hasLastName(requestDTO.getLastName()))
                .and(UserSpecification.hasPersonalMail(requestDTO.getPersonalMail()))
                .and(UserSpecification.hasPrimaryMobileNo(requestDTO.getPrimaryMobileNo()))
                .and(UserSpecification.hasSecondaryMobileNo(requestDTO.getSecondaryMobileNo())));

        Pageable pageable = PageRequest.of(requestDTO.getPageIndex(), requestDTO.getPageSize(), Sort.by(Sort.Direction.DESC, "cretedDate"));
        Page<User> page = userRepository.findAll(specification, pageable);
        List<GetUserResponseDTO> responseList = new ArrayList<>();
        if (page.isEmpty()) {
            return responseList;
        }
        List<User> userList = page.getContent();
        for (User user : userList) {
            responseList.add(GetUserResponseDTO.builder()
                    .firstName(user.getFirstName())
                    .middleName(user.getMiddleName())
                    .lastName(user.getLastName())
                    .personalMail(user.getPersonalMail())
                    .primaryMobileNo(user.getPrimaryMobileNo())
                    .secondaryMobileNo(user.getSecondaryMobileNo())
                    .build()
            );
        }
        return responseList;
    }
}
