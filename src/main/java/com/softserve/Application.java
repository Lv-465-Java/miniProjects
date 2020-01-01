package com.softserve;


import com.softserve.dao.implementation.RecordDAOImpl;
import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.entity.User;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {


        RecordDAOImpl recordDAO = new RecordDAOImpl();
        UserDAOImpl userDAO = new UserDAOImpl();

        System.out.println(userDAO.save(new User("jhk", "Hoper",
                "markhoper@gmail.com", "mjdsafio86sd")));



//        System.out.println(recordDAO.generateSearchQuery(1L, map));
//        System.out.println(recordDAO.getAllBySelectedFilters(1L, map));

    }
}