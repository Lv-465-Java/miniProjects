package com.auto.controller;

import com.auto.model.Check;
import com.auto.service.impl.CheckServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private CheckServiceImpl checkService;

    @Override
    public void init() {
        checkService = new CheckServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String date = req.getParameter("date");
        Check check = new Check(Integer.valueOf(id), date);
        checkService.update(check);
        resp.sendRedirect(req.getContextPath() + "/admin/cars");
    }
}
