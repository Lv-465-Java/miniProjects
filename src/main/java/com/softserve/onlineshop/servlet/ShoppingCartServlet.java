package com.softserve.onlineshop.servlet;

import com.softserve.onlineshop.service.PhoneService;
import com.softserve.onlineshop.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {
//    private Long phoneId;
//    private PhoneService phoneService;

    @Override
    public void init() {
//        phoneService = new PhoneServiceImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        phoneId = Long.parseLong(request.getParameter("phoneId"));
        request.getRequestDispatcher("/WEB-INF/views/shopping-cart.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
