package com.softserve.service.mapper;

import com.softserve.constant.ErrorMessage;
import com.softserve.dto.UserDTO;
import com.softserve.entity.User;

import java.util.Optional;

public class UserMapperObjects {

    public static UserDTO userEntityToUserDTO(User entity) {
        return new UserDTO(entity.getId(), entity.getFirstName(),
                entity.getLastName(), entity.getEmail(), entity.getPassword(),
                entity.getPhoto());
    }

    public static User verifyIfUserIsPresent(Optional<User> optionalUser) {
        if (!optionalUser.isPresent()) {
            throw new RuntimeException(ErrorMessage.FAIL_TO_FIND_A_USER.getErrorMessage());
        }
        return optionalUser.get();
    }
}