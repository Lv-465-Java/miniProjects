package com.softserve;

import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.entity.User;

import java.sql.SQLException;

public class Application {

    public static void main (String[]args) throws SQLException {

        User us1 = new User("Halina", "Yat", "dsf@ndi.e", "lkjjoi");
        UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.save(us1));

        us1.setPhoto("photo.photo");
        System.out.println(userDAO.getById(2L));


    }
}
