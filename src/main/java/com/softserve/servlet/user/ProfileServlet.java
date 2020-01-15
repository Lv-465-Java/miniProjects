package com.softserve.servlet.user;

import com.softserve.constant.View;
import com.softserve.dto.UserDTO;
import com.softserve.service.implementation.CategoryServiceImpl;
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

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {
    private UserSession userSession;
    private UserServiceImpl userService;
    private CategoryServiceImpl categoryService;

    @Override
    public void init() {
        this.userService = new UserServiceImpl();
        this.categoryService = new CategoryServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger LOG = LoggerFactory.getLogger(ProfileServlet.class);
        UserDTO currentSessionUser = userSession.retrieveUserIdFromSession(req);
        UserDTO userWithAllInfo = userService.getByEmail(currentSessionUser.getEmail());
        Long id = userWithAllInfo.getId();
        req.setAttribute("user", userWithAllInfo);
        req.setAttribute("categories", categoryService.getAllByUserId(id));
        req.setAttribute("financialTypes", categoryService.getTypes());
        req.getRequestDispatcher(View.USER_PROFILE_PAGE.getViewUrl()).include(req, resp);
    }
}