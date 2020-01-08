package com.softserve.onlineshop.servlet.user;

import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/UserLogin", "/login", "/"})
public class UserLoginServlet extends HttpServlet {
    private UserServiceImpl userService;

    public UserLoginServlet() {
        super();
        userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = new UserDto(
                request.getParameter("nickname"),
                request.getParameter("password"));
        if (userService.isValid(userDto)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userDto", userDto);
            session.setMaxInactiveInterval(300000);
            Cookie cookie = new Cookie("id_session", session.getId());
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath()
                    + "/index");
        } else {
            // Show Error Validator
            request.setAttribute("error", "Bad Login or Password");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(request, response);
        }
    }
}
