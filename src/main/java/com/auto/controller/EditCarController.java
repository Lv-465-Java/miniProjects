package com.auto.controller;

import com.auto.model.Check;
import com.auto.service.impl.CheckServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-car")
public class EditCarController extends HttpServlet {
    private final static String add = "WEB-INF/view/admin/edit-car.jsp";
    private CheckServiceImpl checkService;

    @Override
    public void init() {
        checkService = new CheckServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Check check = checkService.findById(Integer.valueOf(id));
        req.setAttribute("check", check);
        RequestDispatcher dispatcher = req.getRequestDispatcher(add);
        dispatcher.forward(req, resp);
        req.getRequestDispatcher(add).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
