package com.softserve;

import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.UserServiceImpl;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {

        UserDAOImpl userDAO = new UserDAOImpl();
        UserServiceImpl userService = new UserServiceImpl();

        userService.changePassword(13L, "qwerty",
                "qwerty1", "qwerty1");
    }




}