package com.softserve.onlineshop.servlet.cart;

import com.softserve.onlineshop.service.CartService;
import com.softserve.onlineshop.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-cart")
public class DeleteCartServlet extends HttpServlet {
    private CartService cartService;

    @Override
    public void init() {
        cartService = new CartServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/shopping-cart.jsp").include(request, response);
        response.sendRedirect(request.getContextPath() + "/shopping-cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("phoneId") != null) {
            cartService.deleteById(Long.parseLong(request.getParameter("phoneId")));
        }
        doGet(request, response);
    }
}
