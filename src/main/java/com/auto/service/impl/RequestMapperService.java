package com.auto.service.impl;

import com.auto.dto.CarDto;
import com.auto.dto.CheckDto;
import com.auto.dto.ClientDto;
import com.auto.model.Car;
import com.auto.model.Check;
import com.auto.model.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RequestMapperService {


    private CheckServiceImpl checkService;
    private CarServiceImpl carService;
    private ClientServiceImpl clientService;
    private List<Check> checks;
    private List<Car> cars;
    private List<Client> clients;

    public RequestMapperService(){
     checkService = new CheckServiceImpl();
        carService = new CarServiceImpl();
        clientService = new ClientServiceImpl();
    }
    public void getAllEntities(HttpServletRequest req) throws ServletException, IOException {
        String field = req.getParameter("field");
        String brand = req.getParameter("brand");
        int page = 1;
        if (req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));
        checks = checkService.getPaginationChecks(page);
        if (field != null)
            checks = checkService.getByField(field);
        if (brand != null)
            checks = checkService.getByBrand(brand);
        cars = carService.findAll();
        clients = clientService.findAll();
        Integer size = checkService.countPages();
        req.setAttribute("size", size);
        req.setAttribute("cars", cars);
        req.setAttribute("clients", clients);
        req.setAttribute("checks", checks);

    }
    public void createEntity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        resp.sendRedirect(req.getContextPath() + "/admin/cars");
    }
}
