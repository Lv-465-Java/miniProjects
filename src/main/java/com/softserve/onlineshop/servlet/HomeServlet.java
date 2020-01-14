package com.softserve.onlineshop.servlet;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.PhoneService;
import com.softserve.onlineshop.service.ProducerService;
import com.softserve.onlineshop.service.UserService;
import com.softserve.onlineshop.service.impl.ModelServiceImpl;
import com.softserve.onlineshop.service.impl.PhoneServiceImpl;
import com.softserve.onlineshop.service.impl.ProducerServiceImpl;
import com.softserve.onlineshop.util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private PhoneService phoneService;
    private ModelService modelService;
    private ProducerService producerService;
    private UserService userService;

    @Override
    public void init() {
        phoneService = new PhoneServiceImpl();
        modelService = new ModelServiceImpl();
        producerService = new ProducerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("phones", phoneService.getAll());
            request.setAttribute("models", modelService.getAll());
            request.setAttribute("producers", producerService.getAll());
//            request.setAttribute("producers", producers);
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").include(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("error", "Empty phones list");
            request.getRequestDispatcher("/WEB-INF/views/home.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
