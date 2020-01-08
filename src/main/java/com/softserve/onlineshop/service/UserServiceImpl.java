package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dao.impl.UserDaoImpl;
import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.entity.User;
import com.softserve.onlineshop.exception.NotDeletedException;
import com.softserve.onlineshop.exception.NotFoundException;
import com.softserve.onlineshop.exception.NotInsertedException;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean insert(UserDto userDto) {
        if (userDao.getById(userDto.getId()).isPresent()) {
            throw new NotInsertedException();
        } else {
            User user = new User(userDto.getNickname(), userDto.getPassword(), userDto.getEmail(),
                    userDto.getPhone(), userDto.getCartId());
            userDao.insert(user);
            return true;
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.of(userDao.getById(id))
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public List<User> getAll() {
        List<User> users = userDao.getAll();
        if (users.isEmpty()) {
            throw new NotFoundException();
        }
        return users;
    }

    @Override
    public boolean updateById(String... args) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (userDao.getById(id).isPresent()) {
            userDao.deleteById(id);
            return true;
        } else {
            throw new NotDeletedException();
        }
    }

    public boolean isValid(UserDto userDto) {
        User user = userDao.getByFieldName(userDto.getNickname()).get(0);
        if (user != null) {
            return user.getNickname().equals(userDto.getNickname())
                    && user.getPassword().equals(userDto.getPassword());
        } else {
            throw new NotFoundException("User not found");
        }
    }
}
