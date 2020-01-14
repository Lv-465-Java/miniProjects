package utils;

import dto.UserDto;
import dto.UserLoginDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionCookieManager {

    public static void storeLoginedUser(HttpSession session, UserDto userDto) {
        session.setAttribute("userDto", userDto);
    }

    public static UserDto getLoginedUser(HttpSession session) {
        return (UserDto) session.getAttribute("userDto");
    }

    public static void storeUserCookie(HttpServletResponse response, UserDto user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie("userDto", user.getUsername());
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }

    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userDto".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static Cookie getIdSessionInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id_session")) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie("userDto", null);
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
}
