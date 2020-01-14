package com.blog.controller.common;

import com.blog.dto.LoginDto;
import com.blog.dto.UserDto;
import com.blog.service.UserService;
import com.blog.service.impl.UserServiceImpl;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Security {

    private UserService userService;

    public Security() {
        this.userService = new UserServiceImpl();
    }

    public static boolean checkSession(HttpServletRequest req, HttpServletResponse resp){
        boolean isActiveSession = true;
        HttpSession session = req.getSession(false);
        Cookie idSessionCookie = null;
        if ((req != null) && (req.getCookies() != null)) {

            for (Cookie currentCookie : req.getCookies()) {
                if (currentCookie.getName().equals("id_session")) {
                    idSessionCookie = currentCookie;
                    break;
                }
            }
        }
        isActiveSession = isActiveSession && (session != null)
                && (session.getAttribute("loginDto") != null)
                && (((LoginDto) (session.getAttribute("loginDto"))).getUsername() != null)
                && (idSessionCookie != null);
        return  isActiveSession
                && (idSessionCookie.getValue().equals(session.getId()));
    }

    public boolean isAdmin(LoginDto loginDto){
        boolean isAdmin = false;
        UserDto userDto = userService.findUserByUsername(loginDto.getUsername());
        if (userDto.getRoleId().equals("1")){
            isAdmin = true;
        }

        return isAdmin;
    }
}
