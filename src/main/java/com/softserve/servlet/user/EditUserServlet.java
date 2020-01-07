package com.softserve.servlet.user;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.UserDTO;
import com.softserve.exception.NoSuchEntityException;
import com.softserve.service.implementation.UserServiceImpl;
import com.softserve.util.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/edit-user"})
public class EditUserServlet extends HttpServlet {
    private UserSession userSession;
    private UserServiceImpl userService;

    @Override
    public void init() {
        userService = new UserServiceImpl();
        userSession = new UserSession();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentSessionUser = userSession.retrieveUserIdFromSession(req);
        String firstName = req.getParameter(ServletResponseParameter.USER_FIRST_NAME.getServletParameter());
        String lastName = req.getParameter(ServletResponseParameter.USER_LAST_NAME.getServletParameter());
        UserDTO userBuild = UserDTO.Builder.builder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();
        try {
            userService.update(currentSessionUser.getId(), userBuild);
            resp.sendRedirect(req.getContextPath() + "/profile");

        } catch (NoSuchEntityException e) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.USER_PROFILE_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}