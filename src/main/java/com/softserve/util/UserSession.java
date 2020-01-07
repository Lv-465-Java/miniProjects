package com.softserve.util;

import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSession {
    private UserServiceImpl userService;

    public static String createSession(HttpServletRequest request, UserDTO user) {
        HttpSession session = request.getSession(true);
        session.setAttribute("currentSessionUser", user);
        session.setMaxInactiveInterval(300000);
        return session.getId();
    }

    public static void createCookie(String sessionId, HttpServletResponse response) {
        Cookie cookie = new Cookie("id_session", sessionId);
        response.addCookie(cookie);
    }

    public UserDTO retrieveUserIdFromSession(HttpServletRequest request) {
        userService = new UserServiceImpl();
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("currentSessionUser");
        return userService.getByEmail(userDTO.getEmail());
    }
}