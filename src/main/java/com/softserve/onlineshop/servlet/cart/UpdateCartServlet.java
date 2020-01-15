package com.softserve.onlineshop.servlet.cart;


import com.softserve.onlineshop.dto.CartDto;
import com.softserve.onlineshop.service.CartService;
import com.softserve.onlineshop.service.UserService;
import com.softserve.onlineshop.service.impl.CartServiceImpl;
import com.softserve.onlineshop.service.impl.UserServiceImpl;
import com.softserve.onlineshop.util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-cart")
public class UpdateCartServlet extends HttpServlet {
    private CartService cartService;
    private UserService userService;

    @Override
    public void init() {
        cartService = new CartServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/shopping-cart.jsp").include(request, response);
        response.sendRedirect(request.getContextPath() + "/shopping-cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long phoneId = Long.parseLong(request.getParameter("update"));
        CartDto cartDto = new CartDto(phoneId, SessionUtil.getUserFromSession(request, userService).getId());
        try {
            cartService.buyProduct(cartDto, phoneId);
        } catch (RuntimeException ex) {
            request.setAttribute("error", "Phone has already bought");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/update-producer.jsp")
                    .forward(request, response);
        }
        doGet(request, response);
    }
}
