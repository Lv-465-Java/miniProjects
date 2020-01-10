package com.softserve.servlet.category;

import com.softserve.constant.ServletResponseParameter;
import com.softserve.constant.View;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.implementation.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/delete-category"})
public class DeleteCategoryServlet extends HttpServlet {

    private CategoryServiceImpl categoryService;

    @Override
    public void init() {
        categoryService = new CategoryServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long categoryId = Long.parseLong(req.getParameter("buttondelete"));
        req.setAttribute("category", categoryService.getById(categoryId));
        req.getRequestDispatcher(View.CATEGORY_DELETE_PAGE.getViewUrl()).include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet(req,resp);
        System.out.println(req.getRequestURL());
        Long id = Long.parseLong(req.getParameter("buprofile"));
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