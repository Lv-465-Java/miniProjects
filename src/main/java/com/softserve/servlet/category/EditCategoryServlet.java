package com.softserve.servlet.category;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.dto.CategoryDTO;
import com.softserve.exception.NoSuchEntityException;
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

@WebServlet(value = {"/edit-category"})
public class EditCategoryServlet extends HttpServlet {
    private CategoryServiceImpl categoryService;
    private UserServiceImpl userService;
    private UserSession userSession;

    @Override
    public void init() {
        this.categoryService = new CategoryServiceImpl();
        this.userService = new UserServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("category_id"));

        Logger LOG = LoggerFactory.getLogger(EditCategoryServlet.class);
        LOG.info("MY ID " + id);


        String title = req.getParameter(ServletResponseParameter.CATEGORY_TITLE.getServletParameter());
        String color = req.getParameter(ServletResponseParameter.CATEGORY_COLOR.getServletParameter());
        String description = req.getParameter(ServletResponseParameter.CATEGORY_DESCRIPTION.getServletParameter());
        Long financialTypeId = Long.parseLong(req.getParameter(ServletResponseParameter.CATEGORY_FINANCIAL_TYPE.getServletParameter()));

        CategoryDTO categoryDTO = CategoryDTO.Builder.aCategoryDTO()
                .withTitle(title)
                .withColor(color)
                .withDescription(description)
                .withFinancialTypeId(financialTypeId)
                .build();
        try {
            categoryService.update(id, categoryDTO);
            resp.sendRedirect(req.getContextPath() + "/profile");

            LOG.info("here");
        } catch (NoSuchEntityException e) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.USER_PROFILE_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}