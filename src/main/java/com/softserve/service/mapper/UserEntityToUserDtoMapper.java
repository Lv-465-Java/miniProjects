package com.softserve.service.mapper;

import com.softserve.dto.UserDTO;
import com.softserve.entity.User;

public class UserEntityToUserDtoMapper {

    public static UserDTO map(User entity) {
        return new UserDTO(entity.getId(), entity.getFirstName(),
                entity.getLastName(), entity.getEmail(), entity.getPassword(),
                entity.getPhoto());
    }
}