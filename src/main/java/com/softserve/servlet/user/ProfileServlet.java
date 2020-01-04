package com.softserve.servlet.user;

import com.softserve.constant.View;
import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.dto.UserDTO;
import com.softserve.entity.User;
import com.softserve.service.implementation.UserServiceImpl;
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

    private UserServiceImpl userService;
    //private CategoryServiceImpl categoryService;

    @Override
    public void init() {
        userService = new UserServiceImpl();
        //categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO user = (UserDTO)req.getSession().getAttribute("currentSessionUser");

        UserDTO userWithAllInfo = userService.getByEmail(user.getEmail());
        Long id = userWithAllInfo.getId();

        Logger LOG = LoggerFactory.getLogger(ProfileServlet.class);
        LOG.info("user " + user);

            req.setAttribute("user", userWithAllInfo);
            //    req.setAttribute("categories", categoryService.getAllByUserId(id));
            req.getRequestDispatcher(View.USER_PROFILE_PAGE.getViewUrl()).include(req, resp);
    }
}