package com.softserve.onlineshop.servlet;

import com.softserve.onlineshop.dto.*;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.service.*;
import com.softserve.onlineshop.service.impl.*;
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
    private CartService cartService;

    @Override
    public void init() {
        phoneService = new PhoneServiceImpl();
        modelService = new ModelServiceImpl();
        producerService = new ProducerServiceImpl();
        userService = new UserServiceImpl();
        cartService = new CartServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        phoneId = Long.parseLong(request.getParameter("phoneId"));
        PhoneDto phoneDto = phoneService.getByIdDto(phoneId);
        ModelDto modelDto = modelService.getByIdDto(phoneDto.getModelId());
        ProducerDto producerDto = producerService.getByIdDto(modelDto.getProducerId());
        UserDto userDto = SessionUtil.getUserFromSession(request, userService);
        request.setAttribute("phoneDto", phoneDto);
        request.setAttribute("modelDto", modelDto);
        request.setAttribute("producerDto", producerDto);
        request.setAttribute("userDto", userDto);
        request.getRequestDispatcher("/WEB-INF/views/product-page.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CartDto cartDto = new CartDto(Long.parseLong(request.getParameter("phoneId")),
                    Long.parseLong(request.getParameter("userId")));
            cartService.addToCart(cartDto);
            request.setAttribute("success", "Phone has been successfully added to cart");
            doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/product-page.jsp")
                    .forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("error", "Phone has already in cart");
            doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/product-page.jsp")
                    .forward(request, response);
        }
    }
}
