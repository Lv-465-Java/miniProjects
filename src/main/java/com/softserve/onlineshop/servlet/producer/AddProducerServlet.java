package com.softserve.onlineshop.servlet.producer;

import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.entity.Producer;
import com.softserve.onlineshop.exception.NotFoundException;
import com.softserve.onlineshop.service.ProducerService;
import com.softserve.onlineshop.service.impl.ProducerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add-producer")
public class AddProducerServlet extends HttpServlet {
    private ProducerService producerService;

    @Override
    public void init() {
        producerService = new ProducerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<ProducerDto> producers = producerService.getAll();
            request.setAttribute("producers", producers);
            request.getRequestDispatcher("/WEB-INF/views/add-producer.jsp").include(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("error", "Empty producer list");
            request.getRequestDispatcher("/WEB-INF/views/add-producers.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            producerService.save(new ProducerDto(request.getParameter("name")));
            request.setAttribute("success", "Producer successfully added");
            doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/add-producer.jsp")
                    .forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("error", "Producer already exist");
            doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/add-producer.jsp")
                    .forward(request, response);
        }
    }
}
