package com.blog.controller.user;

import com.blog.constant.Parameter;
import com.blog.controller.ViewUrls;
import com.blog.controller.common.Security;
import com.blog.dto.LoginDto;
import com.blog.dto.UserDto;
import com.blog.service.UserService;
import com.blog.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet {

    private UserService userService;
    private Security security;

    public UserProfileServlet() {
        this.userService = new UserServiceImpl();
        this.security = new Security();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        LoginDto loginDto = (LoginDto) session.getAttribute("loginDto");
        req.setAttribute("user", userService.findUserByUsername(loginDto.getUsername()));
        req.setAttribute("isAdmin", security.isAdmin(loginDto));
        req.setAttribute("session", Security.checkSession(req, resp));
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.USER_PROFILE.toString())
                .forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
