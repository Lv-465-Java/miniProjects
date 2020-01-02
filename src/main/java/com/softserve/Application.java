package com.softserve;


import com.softserve.dao.implementation.RecordDAOImpl;
import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.entity.User;
import com.softserve.service.implementation.UserServiceImpl;
import com.softserve.servlet.LoginServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class Application {

    public static void main(String[] args) throws SQLException {


        RecordDAOImpl recordDAO = new RecordDAOImpl();
        UserDAOImpl userDAO = new UserDAOImpl();
        UserServiceImpl userService = new UserServiceImpl();



       // System.out.println(userService.create(new User("Mike", "Hanigan", "mikeh@gmail.com", "kdjoisfj")));
        //System.out.println(userService.login("mikeh@gmail.com", "kdjoisfj"));
//        System.out.println(userDAO.save(new User("jhk", "Hoper",
//                "markhoper@gmail.com", "mjdsafio86sd")));

//        Map<String, String> map = new TreeMap<>();
//        map.put("begin_date", "2000-12-12");
//        map.put("end_date", "2022-12-12");
//
//        System.out.println(recordDAO.generateSearchQuery(1L, map));
//        System.out.println(recordDAO.getAllBySelectedFilters(1L, map));

    }
}