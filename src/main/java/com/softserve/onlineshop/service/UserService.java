package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dao.mapper.PhoneRowMapper;
import com.softserve.onlineshop.dao.mapper.RowMapper;
import com.softserve.onlineshop.dao.mapper.UserRowMapper;
import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean save(UserDto userDto);

    User getById(Long id);

    UserDto getByIdDto(Long id);

//    Optional<User> getById(Long id);

    List<User> getAll();

    UserDto getByNickname(String name);

    boolean updateById(Long id);

    boolean deleteById(Long id);

    boolean isValid(UserDto userDto);
}
