package utils;

import com.mysql.cj.Session;
import dto.UserDto;
import dto.UserLoginDto;
import entity.User;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class SessionCookieManager {
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    // Store Connection in request attribute.
    // (Information stored only exist during requests)
//    public static void storeConnection(ServletRequest request, Connection conn) {
//        request.setAttribute(ATT_NAME_CONNECTION, conn);
//    }
//
//    // Get the Connection object has been stored in attribute of the request.
//    public static Connection getStoredConnection(ServletRequest request) {
//        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
//        return conn;
//    }

    public static HttpSession getSession(HttpServletRequest request){
        return request.getSession(false);
    }


    // Store user info in Session.
    public static void storeLoginedUser(HttpSession session, UserDto userDto) {
        // On the JSP can access via ${userDto}
        session.setAttribute("userDto", userDto);
    }

    // Get the user information stored in the session.
    public static UserDto getLoginedUser(HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute("userDto");
        return userDto;
    }

    // Store info in Cookie
    public static void storeUserCookie(HttpServletResponse response, UserLoginDto user){
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUsername());
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }

    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
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

    // Delete cookie.
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
}
