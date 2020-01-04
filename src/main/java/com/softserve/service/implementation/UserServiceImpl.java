package com.softserve.service.implementation;

import com.softserve.constant.ErrorMessage;
import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.dto.UserDTO;
import com.softserve.entity.User;
import com.softserve.exception.NoSuchEntityException;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.CrudService;
import com.softserve.service.mapper.UserMapperObjects;

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

    public void login(String email, String password) throws RuntimeException {
        Optional<User> user = userDAOImpl.getByEmail(email);
        if (user.isPresent()) {
            if (!user.get().getPassword().equals(password)) {
                throw new NotCompletedActionException(ErrorMessage.FAIL_TO_LOGIN_WITH_WRONG_PASSWORD.getErrorMessage());
            }
        } else {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_LOGIN_WITH_WRONG_EMAIL.getErrorMessage());
        }
    }

    @Override
    public UserDTO getById(Long id) {
        User user = UserMapperObjects.verifyIfUserIsPresent(userDAOImpl.getById(id));
        return UserMapperObjects.userEntityToUserDTO(user);
    }

    public UserDTO getByEmail(String email) {
        Optional<User> user = userDAOImpl.getByEmail(email);
        if (!user.isPresent()) {
            throw new NoSuchEntityException(ErrorMessage.FAIL_TO_FIND_A_USER.getErrorMessage());
        }
        return UserMapperObjects.userEntityToUserDTO(user.get());
    }


    //test on web!
    @Override
    public boolean update(Long id, UserDTO userDTO) {
        User user = UserMapperObjects.verifyIfUserIsPresent(userDAOImpl.getById(id));
        if (userDTO.getFirstName() != null) {
            user.setFirstName(userDTO.getFirstName());
        }
        if (userDTO.getLastName() != null) {
            user.setLastName(userDTO.getLastName());
        }
        if (userDTO.getPhoto() != null) {
            user.setPhoto(userDTO.getPhoto());
        }
        return userDAOImpl.update(id, user);
    }

    public boolean changePassword(Long id, String oldPassword, String newPassword, String confirmNewPassword)
            throws NoSuchEntityException, NotCompletedActionException {
        User user = UserMapperObjects.verifyIfUserIsPresent(userDAOImpl.getById(id));
        if (checkCurrentPassword(user, oldPassword)
                && confirmNewPassword(newPassword, confirmNewPassword)) {
            user.setPassword(newPassword);
            return userDAOImpl.update(id, user);
        } else {
            return false;
        }
    }

    private boolean confirmNewPassword(String newPassword, String confirmNewPassword) throws NotCompletedActionException {
        if (!newPassword.equals(confirmNewPassword)) {
            throw new NotCompletedActionException(ErrorMessage.PASSWORDS_DO_NOT_MATCH.getErrorMessage());
        }
        return true;
    }

    private boolean checkCurrentPassword(User user, String currentPassword) throws NoSuchEntityException {
        if (!user.getPassword().equals(currentPassword)) {
            throw new NoSuchEntityException(ErrorMessage.INCORRECT_CURRENT_PASSWORD.getErrorMessage());
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        if (!userDAOImpl.delete(id)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_FIND_A_USER.getErrorMessage());
        }
        return true;
    }

    public boolean logout(Long sessionId) {
        return true;
    }
}