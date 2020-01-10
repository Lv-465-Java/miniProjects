package com.softserve.onlineshop.servlet.user;

import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.service.UserService;
import com.softserve.onlineshop.service.UserServiceImpl;
import com.softserve.onlineshop.util.SessionUtil;

import javax.annotation.security.DeclareRoles;
import javax.resource.spi.AuthenticationMechanism;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet({"/UserLogin", "/login", "/"})
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService;

    public UserLoginServlet() {
        super();
        userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = new UserDto(request.getParameter("nickname"),
                request.getParameter("password"));
        try {
            userService.isValid(userDto);
            SessionUtil.createSession(userDto, request, response);
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (RuntimeException ex) {
            request.setAttribute("error", "Bad Login or Password");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(request, response);
        }
    }
}
