package com.auto.controller;

import com.auto.dto.CarDto;
import com.auto.dto.CheckDto;
import com.auto.dto.ClientDto;
import com.auto.service.impl.CarServiceImpl;
import com.auto.service.impl.CheckServiceImpl;
import com.auto.service.impl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-car")
public class CarCreateController extends HttpServlet {
    private final static String add = "WEB-INF/view/admin/add-car.jsp";
    private CarServiceImpl carService;
    private ClientServiceImpl clientService;
    private CheckServiceImpl checkService ;

    @Override
    public void init() {
        carService = new CarServiceImpl();
        clientService = new ClientServiceImpl();
        checkService = new CheckServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(add).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String number = req.getParameter("number");
        String vinCode = req.getParameter("vinCode");
        String year = req.getParameter("year");
        CarDto car = new CarDto(brand, model, number, vinCode, Integer.valueOf(year));
        String date = req.getParameter("date");
        Integer idCar = carService.getId();
        Integer idClient = carService.getId();
        CheckDto check = new CheckDto(idCar, idClient, date);
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        ClientDto clientDto = new ClientDto(name, Integer.valueOf(tel));
        clientService.create(clientDto);
        carService.create(car);
        checkService.create(check);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
