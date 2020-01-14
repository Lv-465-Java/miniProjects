package com.softserve.onlineshop.servlet.cart;

import com.softserve.onlineshop.dto.CartDto;
import com.softserve.onlineshop.service.*;
import com.softserve.onlineshop.service.impl.*;
import com.softserve.onlineshop.util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {
    private Long userId;
    private CartService cartService;
    private PhoneService phoneService;
    private ModelService modelService;
    private ProducerService producerService;
    private UserService userService;

    @Override
    public void init() {
        cartService = new CartServiceImpl();
        phoneService = new PhoneServiceImpl();
        modelService = new ModelServiceImpl();
        producerService = new ProducerServiceImpl();
        userService = new UserServiceImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userId = SessionUtil.getUserFromSession(request, userService).getId();
        request.setAttribute("cartElements", cartService.getByUserId(userId));
        request.setAttribute("phones", phoneService.getAll());
        request.setAttribute("models", modelService.getAll());
        request.setAttribute("producers", producerService.getAll());
        request.getRequestDispatcher("/WEB-INF/views/shopping-cart.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
