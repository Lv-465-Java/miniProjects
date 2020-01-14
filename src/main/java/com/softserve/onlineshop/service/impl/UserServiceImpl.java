package com.softserve.onlineshop.service.impl;

import com.softserve.onlineshop.dao.impl.UserDaoImpl;
import com.softserve.onlineshop.dao.mapper.UserRowMapper;
import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.dto.mapper.UserDtoMapper;

import com.softserve.onlineshop.entity.User;
import com.softserve.onlineshop.exception.NotDeletedException;
import com.softserve.onlineshop.exception.NotFoundException;
import com.softserve.onlineshop.exception.NotInsertedException;
import com.softserve.onlineshop.exception.NotValidException;
import com.softserve.onlineshop.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean save(UserDto userDto) {
        if (userDao.getByFieldName(new UserRowMapper(), userDto.getNickname(), userDto.getEmail()).isEmpty()) {
            return userDao.insert(new User(
                    userDto.getNickname(),
                    userDto.getPassword(),
                    userDto.getEmail(),
                    userDto.getPhone()));
        }
        throw new NotInsertedException("User with nickname: "
                + userDto.getNickname() + " exist");
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(new UserRowMapper(), id)
                .orElseThrow(() -> new NotFoundException("User with id: " + id + "doesn`t exist"));
    }

    @Override
    public UserDto getByIdDto(Long id) {
        return new UserDtoMapper().mapToDto(getById(id));
    }

    @Override
    public List<User> getAll() {
        List<User> users = userDao.getAll(new UserRowMapper());
        if (users.isEmpty()) {
            throw new NotFoundException();
        }
        return users;
    }

    @Override
    public UserDto getByNickname(String name) {
        return new UserDtoMapper().mapToDto(userDao.getByFieldName(new UserRowMapper(), name).get(0));
    }

    @Override
    public boolean updateById(Long id) {
        return false;
    }


    @Override
    public boolean deleteById(Long id) {
        if (userDao.getById(new UserRowMapper(), id).isPresent()) {
            userDao.deleteById(id);
            return true;
        } else {
            throw new NotDeletedException();
        }
    }

    public boolean isValid(UserDto userDto) {
        if (!userDao.getByFieldName(new UserRowMapper(), userDto.getNickname()).isEmpty()) {
            User user = userDao.getByFieldName(new UserRowMapper(), userDto.getNickname()).get(0);
            if (user.getNickname().equals(userDto.getNickname())
                    && user.getPassword().equals(userDto.getPassword())) {
                return true;
            } else {
                throw new NotValidException();
            }
        }
        throw new NotFoundException("Don`t login");
    }
}
