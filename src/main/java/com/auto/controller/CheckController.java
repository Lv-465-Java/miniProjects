package com.auto.controller;

import com.auto.model.Car;
import com.auto.model.Check;
import com.auto.model.Client;
import com.auto.service.impl.CarServiceImpl;
import com.auto.service.impl.CheckServiceImpl;
import com.auto.service.impl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class CheckController extends HttpServlet {

    private final static String add = "/WEB-INF/view/show-car.jsp";
    CheckServiceImpl checkService ;
    CarServiceImpl carService ;
    ClientServiceImpl clientService ;

    @Override
    public void init() throws ServletException {
        checkService = new CheckServiceImpl();
        carService = new CarServiceImpl();
        clientService = new ClientServiceImpl();
    }

    private List<Check> checks;
    private List<Car> cars;
    private List<Client> clients;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String field = req.getParameter("field");
        checks = checkService.findAll();
        if(field != null)
            checks = checkService.getByField(field);

        cars = carService.findAll();
        clients = clientService.findAll();
        req.setAttribute("cars",cars);
        req.setAttribute("clients",clients);
        req.setAttribute("checks",checks);
        req.getRequestDispatcher(add).forward(req,resp);
    }
}
