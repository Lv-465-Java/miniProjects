package com.softserve.onlineshop.servlet;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.service.PhoneService;
import com.softserve.onlineshop.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product-page")
public class ProductPageServlet extends HttpServlet {
//    private Long phoneId;
//    private PhoneService phoneService;
    @Override
    public void init() {
//        phoneService = new PhoneServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        phoneId = Long.parseLong(request.getParameter("phoneId"));
//        request.getSession(false).setAttribute("phoneId", phoneId);
//        request.setAttribute("modelId", phoneService.getById(phoneId).getModelId());
//        request.setAttribute("year", phoneService.getById(phoneId).getYear());
//        request.setAttribute("price", phoneService.getById(phoneId).getPrice());
//        request.setAttribute("photo", phoneService.getById(phoneId).getPhoto());
//        request.setAttribute("color", phoneService.getById(phoneId).getColor());
//        request.setAttribute("screen-diagonal", phoneService.getById(phoneId).getScreenDiagonal());
//        request.setAttribute("internal-memory", phoneService.getById(phoneId).getInternalMemory());
//        request.getRequestDispatcher("/WEB-INF/views/product-page.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
