package com.softserve.onlineshop.servlet;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.PhoneService;
import com.softserve.onlineshop.service.ProducerService;
import com.softserve.onlineshop.service.UserService;
import com.softserve.onlineshop.service.impl.ModelServiceImpl;
import com.softserve.onlineshop.service.impl.PhoneServiceImpl;
import com.softserve.onlineshop.service.impl.ProducerServiceImpl;
import com.softserve.onlineshop.service.impl.UserServiceImpl;
import com.softserve.onlineshop.util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/product-page")
public class ProductPageServlet extends HttpServlet {
    private Long phoneId;
    private PhoneService phoneService;
    private ModelService modelService;
    private ProducerService producerService;
    private UserService userService;
    @Override
    public void init() {
        phoneService = new PhoneServiceImpl();
        modelService = new ModelServiceImpl();
        producerService = new ProducerServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        phoneId = Long.parseLong(request.getParameter("phoneId"));
        PhoneDto phoneDto = phoneService.getByIdDto(phoneId);
        ModelDto modelDto = modelService.getByIdDto(phoneDto.getModelId());
        ProducerDto producerDto = producerService.getByIdDto(modelDto.getProducerId());
        UserDto userDto = SessionUtil.getUserIdFromSession(request, userService);
        request.setAttribute("phoneDto", phoneDto);
        request.setAttribute("modelDto", modelDto);
        request.setAttribute("producerDto", producerDto);
        request.setAttribute("userDto", userDto);
        request.getRequestDispatcher("/WEB-INF/views/product-page.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
