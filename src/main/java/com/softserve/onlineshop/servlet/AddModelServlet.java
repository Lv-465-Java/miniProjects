package com.softserve.onlineshop.servlet;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.ProducerService;
import com.softserve.onlineshop.service.impl.ModelServiceImpl;
import com.softserve.onlineshop.service.impl.ProducerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add-model")
public class AddModelServlet extends HttpServlet {
    private ProducerService producerService;
    private ModelService modelService;

    @Override
    public void init() {
        producerService = new ProducerServiceImpl();
        modelService = new ModelServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<ModelDto> models = modelService.getAll();
            List<ProducerDto> producers = producerService.getAll();
            request.setAttribute("models", models);
            request.setAttribute("producers", producers);
            request.getRequestDispatcher("/WEB-INF/views/add-model.jsp").include(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("error", "Empty model list");
            request.getRequestDispatcher("/WEB-INF/views/add-model.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelDto modelDto = new ModelDto(request.getParameter("name"),
                Long.parseLong(request.getParameter("producers")));
        try {
            modelService.save(modelDto);
            request.setAttribute("success", "Model successfully added");
            doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/add-model.jsp")
                    .forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("error", "Model already exist");
            doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/add-model.jsp")
                    .forward(request, response);
        }
    }
}
