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

@WebServlet("/update-producer")
public class UpdateProducerServlet extends HttpServlet {
    private ProducerService producerService;
    private Long producerId;

    @Override
    public void init() {
        producerService = new ProducerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        producerId = Long.parseLong(request.getParameter("update"));
        request.getSession(false).setAttribute("producerId", producerId);
        request.setAttribute("old-name", producerService.getById(producerId).getName());
        request.getRequestDispatcher("/WEB-INF/views/update-producer.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = (Long) request.getSession(false).getAttribute("producerId");
        ProducerDto producerDto = new ProducerDto(request.getParameter("new-name"));
        try {
            producerService.updateById(producerDto, id);
            response.sendRedirect(request.getContextPath() + "/add-producer");
        } catch (RuntimeException ex) {
            request.setAttribute("error", "Producer with name: "
                    + producerDto.getName() + " already exists");
                    getServletConfig()
                            .getServletContext()
                            .getRequestDispatcher("/WEB-INF/views/update-producer.jsp")
                            .forward(request, response);
        }

    }
}
