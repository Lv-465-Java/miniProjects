package com.itacademy.softserve.service;

import com.itacademy.softserve.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    /**
     * Method for user validation.
     *
     * @param userDto UserDto object
     * @return true if name and password are correct
     */
    boolean login(UserDto userDto);

    /**
     * Method for saving new users.
     *
     * @param userDto UserDto object
     * @return true if such user don`t exist
     */
    boolean save(UserDto userDto);

    /**
     * Method for changing password.
     *
     * @param request HTTP request object
     * @return true if password is changed
     */
    boolean changePassword(HttpServletRequest request);

    /**
     * Method for changing username.
     *
     * @param request HTTP request object
     * @return true if name is changed
     */
    boolean changeUsername(HttpServletRequest request);

    /**
     * Method for getting all users.
     *
     * @return list of all users
     */
    List<UserDto> getAll();
}
