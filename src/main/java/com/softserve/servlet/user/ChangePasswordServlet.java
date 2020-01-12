package com.softserve.servlet.user;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.constant.WebServletURL;
import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.UserServiceImpl;
import com.softserve.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/change-user-password"})
public class ChangePasswordServlet extends HttpServlet {

    private UserServiceImpl userService;
    private UserSession userSession;

    @Override
    public void init() {
        userService = new UserServiceImpl();
        userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(View.USER_CHANGE_PASSWORD.getViewUrl()).include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger LOG = LoggerFactory.getLogger(ChangePasswordServlet.class);


        UserDTO userDTO = userSession.retrieveUserIdFromSession(req);

        String currentPassword = req.getParameter(ServletResponseParameter.USER_CURRENT_PASSWORD.getServletParameter());
        String newPassword = req.getParameter(ServletResponseParameter.USER_NEW_PASSWORD.getServletParameter());
        String confirmPassword = req.getParameter(ServletResponseParameter.USER_CONFIRM_PASSWORD.getServletParameter());
        try {
            userService.changePassword(userDTO.getId(), currentPassword, newPassword, confirmPassword);
            resp.sendRedirect(req.getContextPath() + "/profile");
            LOG.info("CHANGED");
        } catch (RuntimeException e) {
            LOG.info("error is :" + e);

            req.setAttribute("errors", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.USER_CHANGE_PASSWORD.getViewUrl())
                    .forward(req, resp);

        }
    }
}