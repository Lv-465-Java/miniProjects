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
import com.itacademy.softserve.util.SessionManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDao();
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

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

    @Override
    public boolean save(UserDto userDto) {
        if (userDao.getByFields(new UserBuilder(), userDto.getName()).isEmpty()) {
            return userDao.insert(new User(userDto.getName(), userDto.getPassword()));
        } else {
            throw new NotSaveException("Don`t save");
        }
    }

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

    @Override
    public boolean changeUsername(HttpServletRequest request) {
        if (SessionManager.isActiveSession(request)) {
            HttpSession session = request.getSession(false);
            String name = ((UserDto) session.getAttribute("userDto")).getName();
            String newName = request.getParameter("newUsername");
            if (newName.isEmpty()) {
                throw  new NotSaveException(ErrorMessage.EMPTY_NAME.toString());
            }
            return userDao.updateByField(UpdateUserParam.USERNAME, newName, name);
        }
        return false;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> users = new ArrayList<>();
        UserDtoMapper userDtoMapper = new UserDtoMapper();
        userDao.getAll(new UserBuilder()).forEach(user -> users.add(userDtoMapper.mapFromEntityToDto(user)));
        return users;
    }
}
