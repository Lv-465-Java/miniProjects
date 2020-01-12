package com.softserve.servlet.category;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.CategoryDTO;
import com.softserve.dto.UserDTO;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.implementation.CategoryServiceImpl;
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
    private UserSession userSession;
    private Logger LOG = LoggerFactory.getLogger(AddCategoryServlet.class);

    @Override
    public void init() {
        this.categoryService = new CategoryServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("financialTypes", categoryService.getTypes());
        req.getRequestDispatcher(View.CATEGORY_ADD_PAGE.getViewUrl()).include(req, resp);
        LOG.info("'Add new Category' Page is loaded");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentSessionUser = userSession.retrieveUserIdFromSession(req);

        String title = req.getParameter(ServletResponseParameter.CATEGORY_TITLE.getServletParameter());
        String color = req.getParameter(ServletResponseParameter.CATEGORY_COLOR.getServletParameter());
        String description = req.getParameter(ServletResponseParameter.CATEGORY_DESCRIPTION.getServletParameter());
        Long financialType = Long.parseLong(req.getParameter(ServletResponseParameter.FINANCIAL_TYPE_ID.getServletParameter()));

        CategoryDTO categoryDTO = CategoryDTO.Builder.aCategoryDTO()
                .withTitle(title)
                .withColor(color)
                .withDescription(description)
                .withUserId(currentSessionUser.getId())
                .withFinancialTypeId(financialType)
                .build();

        try {
            categoryService.create(categoryDTO);
            resp.sendRedirect(req.getContextPath() + "/profile");
            LOG.info("New Category is created. User is redirected to 'User Profile' Page");
        } catch (NotCompletedActionException e) {
            LOG.info("Error: " + e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.USER_PROFILE_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}