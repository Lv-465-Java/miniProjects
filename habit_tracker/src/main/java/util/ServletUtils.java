package util;

import dto.CookieDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletUtils {

    public static void storeLoginedUser(HttpServletResponse response, HttpSession session, CookieDto loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
        Cookie cookie = new Cookie("id_session", session.getId());
        response.addCookie(cookie);
    }


    public static CookieDto getLoginedUser(HttpSession session) {
        CookieDto loginedUser = (CookieDto) session.getAttribute("loginedUser");
        return loginedUser;
    }

    public static void destroySession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("loginedUser");
            session.invalidate();
        }
    }

    public static void deleteUserCookie(HttpServletRequest request, HttpServletResponse response) {
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


}

