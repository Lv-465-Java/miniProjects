package com.softserve.onlineshop.servlet.phone;

import com.softserve.onlineshop.service.PhoneService;
import com.softserve.onlineshop.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-phone")
public class DeletePhoneServlet extends HttpServlet {
    private PhoneService phoneService;

    @Override
    public void init() {
        phoneService = new PhoneServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/add-phone.jsp").include(request, response);
        response.sendRedirect(request.getContextPath() + "/add-phone");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("delete") != null) {
            phoneService.deleteById(Long.parseLong(request.getParameter("delete")));
        }
        doGet(request, response);
    }

}
