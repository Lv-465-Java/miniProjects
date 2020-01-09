package com.softserve.servlet;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.UserDTO;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.implementation.UserServiceImpl;
import com.softserve.util.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserServiceImpl userService;

    @Override
    public void init() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(View.LOGIN_PAGE.getViewUrl()).include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter(ServletResponseParameter.USER_EMAIL.getServletParameter());
            String password = req.getParameter(ServletResponseParameter.USER_PASSWORD.getServletParameter());
            UserDTO userDTO = UserDTO.Builder.builder()
                    .withEmail(email)
                    .withPassword(password)
                    .build();
            userService.login(userDTO);
            String sessionId = UserSession.createSession(req, userDTO);
            UserSession.createCookie(sessionId, resp);
            resp.sendRedirect(req.getContextPath() + "/profile");
        } catch (NotCompletedActionException e) {
            req.setAttribute("error", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.LOGIN_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}