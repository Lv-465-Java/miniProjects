package com.auto.controller;

import com.auto.dto.CarDto;
import com.auto.dto.CheckDto;
import com.auto.dto.ClientDto;
import com.auto.service.impl.CarServiceImpl;
import com.auto.service.impl.CheckServiceImpl;
import com.auto.service.impl.ClientServiceImpl;
import com.auto.service.impl.RequestMapperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-car")
public class CarCreateController extends HttpServlet {
    private final static String add = "WEB-INF/view/admin/add-car.jsp";
    private RequestMapperService mapperService;

    @Override
    public void init() {
        mapperService = new RequestMapperService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(add).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      mapperService.createEntity(req,resp);
    }
}
