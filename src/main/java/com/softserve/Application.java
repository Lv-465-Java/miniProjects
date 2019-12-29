package com.softserve;

import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.entity.User;

import java.sql.SQLException;

public class Application {

    public static void main (String[]args) throws SQLException {

        User us1 = new User("Halina", "Yat", "dsf@ndi.e", "lkjjoi");
        UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.save(us1));
    }
}
