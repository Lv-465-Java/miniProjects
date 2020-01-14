package com.softserve.onlineshop.servlet.model;

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

@WebServlet("/update-model")
public class UpdateModelServlet extends HttpServlet {
    private ModelService modelService;
    private ProducerService producerService;
    private Long modelId;

    @Override
    public void init() {
        modelService = new ModelServiceImpl();
        producerService = new ProducerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelId = Long.parseLong(request.getParameter("update"));
        List<ProducerDto> producers = producerService.getAll();
        request.setAttribute("producers", producers);
        request.getSession(false).setAttribute("modelId", modelId);
        request.setAttribute("old-name", modelService.getById(modelId).getName());
        request.getRequestDispatcher("/WEB-INF/views/update-model.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = (Long) request.getSession(false).getAttribute("modelId");
        ModelDto modelDto = new ModelDto(request.getParameter("new-name"),
                Long.parseLong(request.getParameter("producers")));
        try {
            modelService.updateById(modelDto, id);
            response.sendRedirect(request.getContextPath() + "/add-model");
        } catch (RuntimeException ex) {
            request.setAttribute("error", "Model with name: "
                    + modelDto.getName() + " already exists");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/update-model.jsp")
                    .forward(request, response);
        }
    }
}
