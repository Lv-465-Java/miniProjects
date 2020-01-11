package com.itacademy.softserve.util;

import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.UserDtoMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionManager {
    private static SessionManager sessionManager;

    private SessionManager() {
        sessionManager = new SessionManager();
    }

    public static SessionManager getManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public static void createSession(UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("userDto", userDto);
        Cookie cookie = new Cookie("id_session", session.getId());
        response.addCookie(cookie);
    }

    public static boolean isActiveSession(HttpServletRequest request) {
        boolean isActive = true;
        HttpSession session = request.getSession(false);
        Cookie idSessionCookie = null;
        if ((request != null) && (request.getCookies() != null)) {
            for (Cookie currentCookie : request.getCookies()) {
                if (currentCookie.getName().equals("id_session")) {
                    idSessionCookie = currentCookie;
                    break;
                }
            }
        }
        isActive = isActive && (session != null)
                && (session.getAttribute("userDto") != null)
                && (((UserDto) (session.getAttribute("userDto"))).getName() != null)
                && (idSessionCookie != null);
        isActive = isActive
                && (idSessionCookie.getValue().equals(session.getId()));

        return isActive;
    }

    public static void destroySession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userDto");
            session.invalidate();
        }
        Cookie cookie;
        for (Cookie cook : request.getCookies()) {
            if (cook.getName().equals("id_session")) {
                cookie = cook;
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
    }

    public static void changeSessionAttributeNewUserName(HttpServletRequest request) {
        UserDao userDao = new UserDao();
        UserBuilder userBuilder = new UserBuilder();
        UserDtoMapper userDtoMapper = new UserDtoMapper();
        UserDto userDto = userDtoMapper.mapFromEntityToDto(userDao
                .getByFields(userBuilder, request.getParameter("newUsername")).get(0));
        HttpSession session = request.getSession(false);
        session.setAttribute("userDto", userDto);
    }

    public static void changeSessionAttributeNewPassword(HttpServletRequest request) {
        UserDao userDao = new UserDao();
        UserBuilder userBuilder = new UserBuilder();
        UserDtoMapper userDtoMapper = new UserDtoMapper();
        HttpSession session = request.getSession(false);
        String name = ((UserDto)session.getAttribute("userDto")).getName();
        UserDto userDto = userDtoMapper.mapFromEntityToDto(userDao.getByFields(userBuilder, name).get(0));
        session.setAttribute("userDto", userDto);
    }
}
