package com.blog.service.impl;

import com.blog.dao.UserDao;
import com.blog.dto.LoginDto;
import com.blog.service.UserService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test
    void isValid(){
        LoginDto loginDto = new LoginDto("test", "test");

    }
}
