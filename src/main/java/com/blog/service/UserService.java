package com.blog.service;

import com.blog.dto.LoginDto;
import com.blog.dto.UserDto;

import java.util.List;

public interface UserService {

    boolean save(UserDto userDto);
    UserDto getById(Long id);
    void update(UserDto userDto);
    UserDto findUserByUsername(String username);
    List<UserDto> getAll();
    boolean isValid(LoginDto loginDto);
    boolean isAlreadyExists(String username);
}
