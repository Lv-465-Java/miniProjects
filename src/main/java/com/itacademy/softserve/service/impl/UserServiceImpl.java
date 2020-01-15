package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.param.UpdateUserParam;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.UserDtoMapper;
import com.itacademy.softserve.entity.User;
import com.itacademy.softserve.exception.NotFoundException;
import com.itacademy.softserve.exception.NotSaveException;
import com.itacademy.softserve.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    /**
     * Default constructor.
     */
    public UserServiceImpl() {
        userDao = new UserDao();
    }

    /**
     * Constructor with one parameter.
     *
     * @param userDao UserDao object
     */
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Method for user validation.
     *
     * @param userDto UserDto object
     * @return true if name and password are correct
     */
    @Override
    public boolean login(UserDto userDto) {
        User user = userDao.getByFields(new UserBuilder(), userDto.getName()).get(0);
        if (user != null) {
            return user.getName().equals(userDto.getName())
                    && user.getPassword().equals(userDto.getPassword());
        } else {
            throw new NotFoundException("Don`t login");
        }
    }

    /**
     * Method for saving new users.
     *
     * @param userDto UserDto object
     * @return true if such user don`t exist
     */
    @Override
    public boolean save(UserDto userDto) {
        if (userDao.getByFields(new UserBuilder(), userDto.getName()).isEmpty()) {
            return userDao.insert(new User(userDto.getName(), userDto.getPassword()));
        } else {
            throw new NotSaveException("Don`t save");
        }
    }

    /**
     * Method for changing password.
     *
     * @param request HTTP request object
     * @return true if password is changed
     */
    @Override
    public boolean changePassword(HttpServletRequest request) {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String repeatPassword = request.getParameter("repeatPassword");
        UserDto userDto = (UserDto) request.getSession(false).getAttribute("userDto");
        if (!oldPassword.equals(userDto.getPassword())
                || !newPassword.equals(repeatPassword)) {
            throw new NotSaveException(ErrorMessage.INCORRECT_DATA.toString());
        }
        return userDao.updateByField(UpdateUserParam.PASSWORD, newPassword, userDto.getName());
    }

    /**
     * Method for changing username.
     *
     * @param request HTTP request object
     * @return true if name is changed
     */
    @Override
    public boolean changeUsername(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String name = ((UserDto) session.getAttribute("userDto")).getName();
        String newName = request.getParameter("newUsername");
        if (newName.isEmpty()) {
            throw new NotSaveException(ErrorMessage.EMPTY_NAME.toString());
        }
        return userDao.updateByField(UpdateUserParam.USERNAME, newName, name);
    }

    /**
     * Method for getting all users.
     *
     * @return list of all users
     */
    @Override
    public List<UserDto> getAll() {
        List<UserDto> users = new ArrayList<>();
        UserDtoMapper userDtoMapper = new UserDtoMapper();
        userDao.getAll(new UserBuilder()).forEach(user -> users.add(userDtoMapper.mapFromEntityToDto(user)));
        return users;
    }
}