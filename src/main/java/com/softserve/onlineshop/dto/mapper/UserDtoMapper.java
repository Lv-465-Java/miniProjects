package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.entity.Entity;
import com.softserve.onlineshop.entity.User;

public class UserDtoMapper implements DtoMapper<UserDto> {
    @Override
    public UserDto mapToDto(Entity entity) {
        User user = (User) entity;
        return new UserDto(user.getId(), user.getNickname(),user.getPassword(),
                user.getEmail(),user.getPhone());
    }
}
