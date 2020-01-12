package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean login(UserDto userDto);

    boolean save(UserDto userDto);

    boolean changePassword(HttpServletRequest request);

    boolean changeUsername(HttpServletRequest request);

    List<UserDto> getAll();
}
