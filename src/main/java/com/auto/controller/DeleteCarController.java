package com.auto.controller;

import com.auto.model.Check;
import com.auto.service.impl.CarServiceImpl;
import com.auto.service.impl.CheckServiceImpl;
import com.auto.service.impl.ClientServiceImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/delete")
public class DeleteCarController extends HttpServlet {
    private CheckServiceImpl checkService ;
    private CarServiceImpl carService;
    private ClientServiceImpl clientService;

    @Override
    public void init()  {
        checkService = new CheckServiceImpl();
        carService = new CarServiceImpl();
        clientService = new ClientServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String id = req.getParameter("id");
            Check check = checkService.findById(Integer.valueOf(id));
            Integer idCar = check.getIdCar();
            Integer icClient = check.getIdClient();
            checkService.delete(Integer.valueOf(id));
            carService.delete(idCar);
            clientService.delete(icClient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"/admin/cars");
    }


}
