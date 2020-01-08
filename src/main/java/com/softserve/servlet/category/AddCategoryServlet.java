package com.softserve.servlet.category;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.dto.CategoryDTO;
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

@WebServlet(value = {"/add-category"})
public class AddCategoryServlet extends HttpServlet {

    private CategoryServiceImpl categoryService;
    private UserServiceImpl userService;
    private UserSession userSession;

    @Override
    public void init() {
        categoryService = new CategoryServiceImpl();
        userService = new UserServiceImpl();
        userSession = new UserSession();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //записати айді юзера
        Logger LOG = LoggerFactory.getLogger(AddCategoryServlet.class);
        LOG.info("start");
        UserDTO userDTO = userSession.retrieveUserIdFromSession(req);
        String title = req.getParameter(ServletResponseParameter.CATEGORY_TITLE.getServletParameter());
        String color = req.getParameter(ServletResponseParameter.GATEGORY_COLOR.getServletParameter());
        String description = req.getParameter(ServletResponseParameter.GATEGORY_DESCRIPTION.getServletParameter());
        Long financialType = Long.parseLong(req.getParameter(ServletResponseParameter.GATEGORY_FINANCIAL_TYPE.getServletParameter()));
        CategoryDTO categoryDTO = new CategoryDTO(title, color, description, userDTO.getId(),financialType);
        categoryService.create(categoryDTO);
        resp.sendRedirect(req.getContextPath() + "/profile");
        LOG.info("end");
    }
}