package com.softserve.service.mapper;

import com.softserve.dto.UserDTO;
import com.softserve.entity.User;

import java.util.Optional;

public class UserMapperObjects {

    public static UserDTO map(User entity) {
        return new UserDTO(entity.getId(), entity.getFirstName(),
                entity.getLastName(), entity.getEmail(), entity.getPassword(),
                entity.getPhoto());
    }

    public static User mapper(Optional<User> user) {
        if (!user.isPresent()) {
            throw new RuntimeException("There is not such a user");
        }
        return user.get();
    }
}