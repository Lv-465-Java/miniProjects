package com.softserve.servlet.category;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.CategoryDTO;
import com.softserve.dto.UserDTO;
import com.softserve.exception.NoSuchEntityException;
import com.softserve.service.implementation.CategoryServiceImpl;
import com.softserve.util.UserSession;

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

    @Override
    public void init() {
        this.categoryService = new CategoryServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("editCategoryButton");
        req.setAttribute("category", categoryService.getById(Long.parseLong(categoryId)));
        req.setAttribute("financialTypes", categoryService.getTypes());
        req.getRequestDispatcher(View.CATEGORY_EDIT_PAGE.getViewUrl()).include(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentSessionUser = userSession.retrieveUserIdFromSession(req);
        Long id = Long.parseLong(req.getParameter(ServletResponseParameter.CATEGORY_ID.getServletParameter()));
        String title = req.getParameter(ServletResponseParameter.CATEGORY_TITLE.getServletParameter());
        String color = req.getParameter(ServletResponseParameter.CATEGORY_COLOR.getServletParameter());
        String description = req.getParameter(ServletResponseParameter.CATEGORY_DESCRIPTION.getServletParameter());
        Long financialTypeId = Long.parseLong(req.getParameter(ServletResponseParameter.CATEGORY_FINANCIAL_TYPE.getServletParameter()));

        CategoryDTO categoryDTO = CategoryDTO.Builder.aCategoryDTO()
                .withId(id)
                .withTitle(title)
                .withColor(color)
                .withDescription(description)
                .withUserId(currentSessionUser.getId())
                .withFinancialTypeId(financialTypeId)
                .build();
        try {
            categoryService.update(id, categoryDTO);
            resp.sendRedirect(req.getContextPath() + "/profile");

        } catch (NoSuchEntityException e) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.USER_PROFILE_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}