package com.softserve.onlineshop.servlet;

import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.impl.ModelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-model")
public class ModelDeleteServlet extends HttpServlet {
    private ModelService modelService;

    @Override
    public void init() {
        modelService = new ModelServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/add-model.jsp").include(request, response);
        response.sendRedirect(request.getContextPath() + "/add-model");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("delete") != null) {
            modelService.deleteById(Long.parseLong(request.getParameter("delete")));
        }
        doGet(request, response);
    }
}
