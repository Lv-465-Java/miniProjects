package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.entity.User;

public class UserDtoMapper {
    public UserDto mapToDto(User user) {
        return new UserDto(user.getId(), user.getNickname(),user.getPassword(),
                user.getEmail(),user.getPhone());
    }
}
