package com.softserve;

import com.softserve.dao.implementation.CategoryDAOImpl;
import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.entity.Category;
import com.softserve.entity.User;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLException;

public class Application {

    public static void main (String[]args) throws SQLException {

        User us1 = new User("Halina", "fdsjlfkj", "kjsd'kj.e", "868");
        UserDAOImpl userDAO = new UserDAOImpl();
        CategoryDAOImpl catDAO = new CategoryDAOImpl();
//        System.out.println(userDAO.save(us1));

        System.out.println(userDAO.getById(6L));
//        us1.setPhoto("jfdj;sdl");
//        System.out.println(us1);
//        userDAO.update(2L, us1);

 //       userDAO.delete(3L);

        Category category = new Category("title", "#5479", "short or long description", 4L, 1L);

//        System.out.println(catDAO.save(category));
        System.out.println(catDAO.getById(1L));
       // System.out.println(catDAO.getAllByUserId(4L));
    }
}