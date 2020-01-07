package com.softserve.servlet.user;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.UserServiceImpl;
import com.softserve.util.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/register"})
public class RegistrationServlet extends HttpServlet {

    private UserServiceImpl userService;

    @Override
    public void init() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(View.USER_REGISTRATION_PAGE.getViewUrl()).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String firstName = req.getParameter(ServletResponseParameter.USER_FIRST_NAME.getServletParameter());
            String lastName = req.getParameter(ServletResponseParameter.USER_LAST_NAME.getServletParameter());
            String email = req.getParameter(ServletResponseParameter.USER_EMAIL.getServletParameter());
            String password = req.getParameter(ServletResponseParameter.USER_PASSWORD.getServletParameter());
            UserDTO userDTO = UserDTO.Builder.builder()
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withEmail(email)
                    .withPassword(password)
                    .build();
            userService.create(userDTO);
            String sessionId = UserSession.createSession(req, userDTO);
            UserSession.createCookie(sessionId, resp);
            resp.sendRedirect("/profile");
        } catch (RuntimeException e) {
            req.setAttribute("error", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.USER_REGISTRATION_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}