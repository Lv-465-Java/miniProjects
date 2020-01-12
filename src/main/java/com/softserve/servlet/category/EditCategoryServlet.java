package com.softserve.servlet.category;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.CategoryDTO;
import com.softserve.dto.UserDTO;
import com.softserve.exception.NoSuchEntityException;
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

@WebServlet(value = {"/edit-category"})
public class EditCategoryServlet extends HttpServlet {
    private CategoryServiceImpl categoryService;
    private UserSession userSession;
    private Logger LOG = LoggerFactory.getLogger(EditCategoryServlet.class);
    private Long categoryId;

    @Override
    public void init() {
        this.categoryService = new CategoryServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryId = Long.parseLong(req.getParameter("editCategoryButton"));
        req.setAttribute("category", categoryService.getById(categoryId));
        req.setAttribute("financialTypes", categoryService.getTypes());
        req.getRequestDispatcher(View.CATEGORY_EDIT_PAGE.getViewUrl()).include(req, resp);

        LOG.info("'Edit Category' Page is loaded");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentSessionUser = userSession.retrieveUserIdFromSession(req);
        categoryId = Long.parseLong(req.getParameter(ServletResponseParameter.CATEGORY_ID.getServletParameter()));
        String title = req.getParameter(ServletResponseParameter.CATEGORY_TITLE.getServletParameter());
        String color = req.getParameter(ServletResponseParameter.CATEGORY_COLOR.getServletParameter());
        String description = req.getParameter(ServletResponseParameter.CATEGORY_DESCRIPTION.getServletParameter());
        Long financialTypeId = Long.parseLong(req.getParameter(ServletResponseParameter.FINANCIAL_TYPE.getServletParameter()));

        CategoryDTO categoryDTO = CategoryDTO.Builder.aCategoryDTO()
                .withId(categoryId)
                .withTitle(title)
                .withColor(color)
                .withDescription(description)
                .withUserId(currentSessionUser.getId())
                .withFinancialTypeId(financialTypeId)
                .build();
        try {
            categoryService.update(categoryId, categoryDTO);
            resp.sendRedirect(req.getContextPath() + "/profile");
            LOG.info("Category is updated. User is redirected to 'User Profile' Page");
        } catch (NoSuchEntityException e) {
            LOG.info("Error: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/edit-category");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.CATEGORY_EDIT_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}