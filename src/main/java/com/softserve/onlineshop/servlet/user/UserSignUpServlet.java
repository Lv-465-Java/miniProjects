package com.softserve.onlineshop.servlet.user;

import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.service.UserService;
import com.softserve.onlineshop.service.UserServiceImpl;
import com.softserve.onlineshop.util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet({"/UserSignUp", "/SignUp", "/sign-up", "/register"})
@WebServlet("/register")
public class UserSignUpServlet extends HttpServlet {
    private UserService userService;

    public UserSignUpServlet() {
        super();
        userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = new UserDto(
                request.getParameter("nickname"),
                request.getParameter("password"),
                request.getParameter("email"),
                request.getParameter("phone"));
        try {
            userService.save(userDto);
            SessionUtil.createSession(userDto, request, response);
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (RuntimeException ex) {
            request.setAttribute("error", "User with this nickname or email exist");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/register.jsp")
                    .forward(request, response);
        }
    }
}
