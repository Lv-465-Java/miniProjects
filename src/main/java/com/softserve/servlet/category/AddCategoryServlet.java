package com.softserve.servlet.category;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
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
        this.categoryService = new CategoryServiceImpl();
        this.userService = new UserServiceImpl();
        this.userSession = new UserSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("financialTypes", categoryService.getTypes());
        req.getRequestDispatcher(View.CATEGORY_ADD_PAGE.getViewUrl()).include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger LOG = LoggerFactory.getLogger(AddCategoryServlet.class);
        LOG.info("start");
        UserDTO userDTO = userSession.retrieveUserIdFromSession(req);
        String title = req.getParameter(ServletResponseParameter.CATEGORY_TITLE.getServletParameter());
        String color = req.getParameter(ServletResponseParameter.CATEGORY_COLOR.getServletParameter());
        String description = req.getParameter(ServletResponseParameter.CATEGORY_DESCRIPTION.getServletParameter());
        LOG.info("DESCRIPTION" + description);

//        FinancialType financialType = FinancialType.valueOf(req.getParameter("financialType"));
        Long financialType = Long.parseLong(req.getParameter(ServletResponseParameter.CATEGORY_FINANCIAL_TYPE.getServletParameter()));
        LOG.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + financialType);
        CategoryDTO categoryDTO = CategoryDTO.Builder.aCategoryDTO()
                .withTitle(title)
                .withColor(color)
                .withDescription(description)
                .withUserId(userDTO.getId())
                .withFinancialTypeId(financialType)
                .build();
        categoryService.create(categoryDTO);
        resp.sendRedirect(req.getContextPath() + "/profile");
        LOG.info("end");
    }
}