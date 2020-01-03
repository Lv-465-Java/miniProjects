package com.softserve.service.implementation;

import com.softserve.constant.ErrorMessage;
import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.dto.UserDTO;
import com.softserve.entity.User;
import com.softserve.exception.NoSuchEntityException;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.CrudService;
import com.softserve.service.mapper.UserEntityToUserDtoMapper;

import java.util.Optional;

public class UserServiceImpl implements CrudService<UserDTO> {

    private UserDAOImpl userDAOImpl;

    public UserServiceImpl() {
        this.userDAOImpl = new UserDAOImpl();
    }

    @Override
    public boolean create(UserDTO userDTO) {
        if (userDAOImpl.getByEmail(userDTO.getEmail()).isPresent()) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_REGISTER_A_USER.getErrorMessage());
        } else {
            User user = new User(userDTO.getFirstName(), userDTO.getLastName(),
                    userDTO.getEmail(), userDTO.getPassword());
            return userDAOImpl.save(user);
        }
    }

    public boolean login(String email, String password) throws RuntimeException {
        Optional<User> user = userDAOImpl.getByEmail(email);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                return true;
            } else {
                throw new NotCompletedActionException(ErrorMessage.FAIL_TO_LOGIN_WITH_WRONG_PASSWORD.getErrorMessage());
            }
        } else {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_LOGIN_WITH_WRONG_EMAIL.getErrorMessage());
        }
    }

    @Override
    public UserDTO getById(Long id) {
        Optional<User> user = userDAOImpl.getById(id);
        if (user.isPresent()) {
            return UserEntityToUserDtoMapper.map(user.get());
        } else {
            throw new NoSuchEntityException(ErrorMessage.FAIL_TO_FIND_A_USER.getErrorMessage());
        }
    }

    @Override
    public boolean update(Long id, UserDTO userDTO) {
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }
}