package com.softserve;

import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.UserServiceImpl;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {

        UserDAOImpl userDAO = new UserDAOImpl();
        UserServiceImpl userService = new UserServiceImpl();

//        UserDTO userDTO = new UserDTO("MyFirstName22", "MyLastName1", "MyEmail", "MyPassword");
//        userDTO.setPhoto("MyNewPhotoHere87687");
        //      System.out.println(userService.update(10L));
        //      System.out.println(userService.delete(10L));
        //userService.login("test@example1.com", "new123password");
        }
}