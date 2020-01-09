package com.softserve.onlineshop.util;

import com.softserve.onlineshop.dto.UserDto;

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

}
