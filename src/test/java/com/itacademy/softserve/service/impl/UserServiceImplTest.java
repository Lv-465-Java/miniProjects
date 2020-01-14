package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.UserDtoMapper;
import com.itacademy.softserve.entity.User;
import com.itacademy.softserve.exception.NotFoundException;
import com.itacademy.softserve.exception.NotSaveException;
import com.itacademy.softserve.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class UserServiceImplTest {
    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService service = new UserServiceImpl();

    @BeforeEach
    public void init() {
        initMocks(this);
    }

    @Test
    void login() {
        UserDto userDto = new UserDto("username", "password");
        User user = new User("username", "password");
        List<User> users = Arrays.asList(user);
        when(userDao.getByFields(any(), anyString())).thenReturn(users);
        boolean actual = service.login(userDto);
        assertTrue(actual);
    }

    @Test
    void loginFail() {
        UserDto userDto = new UserDto("username", "password");
        List<User> users = new ArrayList<>();
        users.add(null);
        when(userDao.getByFields(any(), anyString())).thenReturn(users);
        assertThrows(NotFoundException.class, () -> service.login(userDto));
    }


    @Test
    void save() {
        UserDto userDto = new UserDto("username", "password");
        when(userDao.getByFields(any(), anyString())).thenReturn(new ArrayList<>());
        when(userDao.insert(any())).thenReturn(true);
        boolean actual = service.save(userDto);
        assertTrue(actual);
    }

    @Test
    void saveFail() {
        UserDto userDto = new UserDto("username", "password");
        User user = new User("username", "password");
        List<User> users = Arrays.asList(user);
        when(userDao.getByFields(any(), anyString())).thenReturn(users);
        assertThrows(NotSaveException.class, () -> service.save(userDto));
    }

    @Test
    void changePassword() {
        UserDto userDto = new UserDto("username", "oldPassword");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getParameter("oldPassword")).thenReturn(userDto.getPassword());
        when(request.getParameter("newPassword")).thenReturn("newPassword");
        when(request.getParameter("repeatPassword")).thenReturn("newPassword");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute(anyString())).thenReturn(userDto);
        when(userDao.updateByField(anyString(), anyString(), anyString())).thenReturn(true);
        boolean actual = service.changePassword(request);
        assertTrue(actual);
    }

    @Test
    void changePasswordFail() {
        UserDto userDto = new UserDto("username", "oldPassword");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getParameter("oldPassword")).thenReturn("fakePassword");
        when(request.getParameter("newPassword")).thenReturn("newPassword");
        when(request.getParameter("repeatPassword")).thenReturn("newPassword");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute(anyString())).thenReturn(userDto);
        when(userDao.updateByField(anyString(), anyString(), anyString())).thenReturn(true);
        assertThrows(NotSaveException.class, () -> service.changePassword(request));
    }

    @Test
    void changeUsername() {
        UserDto userDto = new UserDto("username", "password");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute(anyString())).thenReturn(userDto);
        when(request.getParameter(anyString())).thenReturn("newName");
        when(userDao.updateByField(anyString(), anyString(), anyString())).thenReturn(true);
        boolean actual = service.changeUsername(request);
        assertTrue(actual);
    }

    @Test
    void changeUsernameFail() {
        UserDto userDto = new UserDto("username", "password");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute(anyString())).thenReturn(userDto);
        when(request.getParameter(anyString())).thenReturn("");
        when(userDao.updateByField(anyString(), anyString(), anyString())).thenReturn(true);
        assertThrows(NotSaveException.class, () -> service.changePassword(request));
    }

    @Test
    void getAll() {
        List<UserDto> users = Arrays.asList(new UserDto("name", "pass"));
        when(userDao.getAll(any())).thenReturn(Arrays.asList(new User("name", "pass")));
        assertEquals(service.getAll(), users);
    }

    @Test
    void getAllFail() {
        List<UserDto> users = Arrays.asList(new UserDto("name", "pass"));
        when(userDao.getAll(any())).thenReturn(new ArrayList<>());
        assertNotEquals(service.getAll(), users);
    }
}