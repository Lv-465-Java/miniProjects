package com.softserve.service.implementation;

import com.softserve.constant.ErrorMessage;
import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.entity.User;
import com.softserve.exception.UserException;
import com.softserve.service.CrudService;

import java.util.Optional;

public class UserServiceImpl implements CrudService<User> {

    private UserDAOImpl userDAOImpl;

    public UserServiceImpl() {
        this.userDAOImpl = new UserDAOImpl();
    }

    @Override
    public boolean create(User user) {
        if (userDAOImpl.getByEmail(user.getEmail()).isPresent()) {
            throw new UserException(ErrorMessage.FAIL_TO_REGISTER_A_USER.getErrorMessage());
        } else {
            return userDAOImpl.save(user) == 1;
        }
    }

    public boolean login(String email, String password) {
        if (userDAOImpl.getByEmail(email).isPresent()) {
            Optional<User> user = userDAOImpl.getByEmail(email);
            if (user.get().getPassword().equals(password)) {
                return true;
            } else {
                throw new RuntimeException("Entered password isn't correct");
            }
        } else {
            throw new RuntimeException("User with entered email isn't created yet");
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        return userDAOImpl.getById(id);
    }

    @Override
    public boolean update(Long id, User object) {
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }
}