package com.softserve.servlet.category;

import com.softserve.constant.View;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.implementation.CategoryServiceImpl;
import com.softserve.servlet.record.AddRecordServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/delete-category"})
public class DeleteCategoryServlet extends HttpServlet {

    private CategoryServiceImpl categoryService;
    private Logger LOG = LoggerFactory.getLogger(AddRecordServlet.class);
    private Long categoryId;

    @Override
    public void init() {
        categoryService = new CategoryServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryId = Long.parseLong(req.getParameter("buttondelete"));
        req.setAttribute("category", categoryService.getById(categoryId));
        req.getRequestDispatcher(View.CATEGORY_DELETE_PAGE.getViewUrl()).include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryId = Long.parseLong(req.getParameter("buprofile"));
        try {
            categoryService.delete(categoryId);
            resp.sendRedirect(req.getContextPath() + "/profile");
            LOG.info("Category is deleted. User is redirected to 'User Profile' Page");
        } catch (NotCompletedActionException e) {
            LOG.info("Error: " + e.getMessage());
            req.setAttribute("error", e.getMessage());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(View.CATEGORY_DELETE_PAGE.getViewUrl())
                    .forward(req, resp);
        }
    }
}