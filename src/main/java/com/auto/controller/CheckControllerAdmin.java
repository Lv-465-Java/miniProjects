package com.auto.controller;

import com.auto.service.impl.RequestMapperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/cars")
public class CheckControllerAdmin extends HttpServlet {

    private final static String add = "/WEB-INF/view/admin/show-car.jsp";
    private RequestMapperService mapperService;

    @Override
    public void init() {
        mapperService = new RequestMapperService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mapperService.getAllEntities(req);
        req.getRequestDispatcher(add).forward(req,resp);
    }
}
