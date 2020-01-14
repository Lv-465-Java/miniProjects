package com.blog.service.impl;

import com.blog.constant.Parameter;
import com.blog.dao.UserDao;
import com.blog.dto.LoginDto;
import com.blog.dto.UserDto;
import com.blog.entity.User;
import com.blog.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final Long ROLE_USER = 2L;

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDao();
    }

    @Override
    public void save(UserDto userDto) {
        User user = new User(userDto.getUsername(),
                userDto.getPassword(),
                userDto.getFirstName(),
                userDto.getLastName(),
                ROLE_USER);

        userDao.insert(user);
    }

    @Override
    public UserDto getById(Long id) {
       User user = userDao.getById(id);
        UserDto userDto = new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getRoleId().toString()
        );
        return userDto;
    }

    @Override
    public void update(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getFirstName(),
                userDto.getLastName(),
                Long.parseLong(userDto.getRoleId())
        );
            userDao.updateByEntity(user);

    }

    @Override
    public UserDto findUserByUsername(String username) {
        User user = userDao.getByFieldName("username", username).get(0);
        if (user != null){
            UserDto userDto = new UserDto(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRoleId().toString()
            );
            return userDto;
        } else {
            throw new RuntimeException("User with" + username + " not found");
        }

    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userDao.getAll()){
            UserDto userDto = new UserDto(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRoleId().toString()
            );

            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public boolean isValid(LoginDto loginDto) {
        boolean result = false;
        try {
            User user = userDao.getByFieldName(Parameter.USERNAME, loginDto.getUsername()).get(0);
            if (user != null){
                if (user.getUsername().equals(loginDto.getUsername()) && user.getPassword().equals(loginDto.getPassword())){
                    result = true;
                }else if(user.getUsername().equals(loginDto.getUsername()) && !user.getPassword().equals(loginDto.getPassword())){
                    result = false;
                }
            }
        }catch (RuntimeException e){
            result = false;
        }

            return result;
    }

    @Override
    public boolean isAlreadyExists(String username) {
        boolean result = false;
        try{
            userDao.getByFieldName(Parameter.USERNAME, username);
            result = true;
        }catch (RuntimeException e){
            result = false;
        }
        return result;
    }
}
