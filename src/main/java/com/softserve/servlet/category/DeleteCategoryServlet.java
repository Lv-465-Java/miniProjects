package com.softserve.servlet.category;

import com.softserve.constant.View;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.implementation.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCategoryServlet extends HttpServlet {

    private CategoryServiceImpl categoryService;

    @Override
    public void init() {
        categoryService = new CategoryServiceImpl();
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        try {
            categoryService.delete(id);
        } catch (NotCompletedActionException e) {
            req.setAttribute("error", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.USER_PROFILE_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}
