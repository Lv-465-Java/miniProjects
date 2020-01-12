package com.softserve.service.mapper;

import com.softserve.constant.ErrorMessage;
import com.softserve.dto.UserDTO;
import com.softserve.entity.User;
import com.softserve.exception.NoSuchEntityException;

import java.util.Optional;

public class UserMapperObjects {

    public static UserDTO userEntityToUserDTO(User entity) {
        return UserDTO.Builder.builder().withId(entity.getId()).withFirstName(entity.getFirstName()).withLastName(entity.getLastName())
                .withEmail(entity.getEmail()).withPassword(entity.getPassword()).withPhoto(entity.getPhoto())
                .build();
    }

    public static User verifyIfUserIsPresent(Optional<User> optionalUser) throws NoSuchEntityException {
        if (!optionalUser.isPresent()) {
            throw new NoSuchEntityException(ErrorMessage.FAIL_TO_FIND_A_USER.getErrorMessage());
        }
        return optionalUser.get();
    }
}