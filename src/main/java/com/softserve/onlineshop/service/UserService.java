package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean insert(UserDto userDto);

    Optional<User> getById(Long id);

    List<User> getAll();

    boolean updateById(String... args);

    boolean deleteById(Long id);
}
