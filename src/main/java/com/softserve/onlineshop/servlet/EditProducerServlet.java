package com.softserve.onlineshop.servlet;

import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.service.ProducerService;
import com.softserve.onlineshop.service.impl.ProducerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit-producer")
public class EditProducerServlet extends HttpServlet {
    private ProducerService producerService;

    @Override
    public void init() {
        producerService = new ProducerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/add-producer.jsp").include(request, response);
        response.sendRedirect(request.getContextPath() + "/add-producer");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("delete") != null) {
            producerService.deleteById(Long.parseLong(request.getParameter("delete")));
        }
        doGet(request, response);
    }
}
