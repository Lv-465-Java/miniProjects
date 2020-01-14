package com.softserve.onlineshop.util;

import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class SessionUtil {

    public static void createSession(UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("userDto", userDto);
        Cookie cookie = new Cookie("id_session", session.getId());
        response.addCookie(cookie);
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

    public static UserDto getUserIdFromSession(HttpServletRequest request, UserService userService) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("userDto");
        return userService.getByNickname(userDto.getNickname());
    }
}
