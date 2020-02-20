package com.auto.service.impl;

import com.auto.dao.impl.CarDaoImpl;
import com.auto.dao.impl.CheckDaoImpl;
import com.auto.dao.impl.ClientDaoImpl;
import com.auto.dto.CheckDto;
import com.auto.dto.mapper.CheckDtoMapper;
import com.auto.model.Check;
import com.auto.service.CheckService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckServiceImpl implements CheckService {
    private CheckDaoImpl checkDao;
    private CheckDtoMapper checkDtoMapper;
    private CarDaoImpl carDao;
    private ClientDaoImpl clientDao;
    public CheckServiceImpl(){
        checkDao = new CheckDaoImpl();
        carDao = new CarDaoImpl();
        clientDao = new ClientDaoImpl();
        checkDtoMapper = new CheckDtoMapper();
    }
    public List<Check> getByBrand(String field){
        return checkDao.getByBrand(field);}
    @Override
    public List<Check> findAll()  {
        List<Check> checks = checkDao.getAll();
        return checks;
    }

    @Override
    public Check findById(Integer id) {
        return checkDao.findById(id);
    }

    public List<Check> getByField(String field){
        return checkDao.getByField(field);
    }

    public Integer countPages(){
        Integer size = checkDao.getAll().size();
        int numPages = size/5;
        if(size%5 !=0)
            numPages +=1;
        return numPages;
    }



    public List<Check> getPaginationChecks(int page){
        List<Check> checks = checkDao.getAll();
        List<Check> result = new ArrayList<>();
        int size = checks.size();
        if(page >size/5){
            for (int i = 0; i < size%5; i++) {
                result.add(checks.get(5 * page + i - 5));
            }
        }
        else {
            for (int i = 0; i < 5; i++) {
                result.add(checks.get(5 * page + i - 5));
            }
        }

        return result;
    }


    @Override
    public void create(CheckDto entity) {
        try {
            checkDao.create(checkDtoMapper.convertFromDto(entity));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Check entity) {
        try{
            checkDao.update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
    checkDao.delete(id);
    }

    public Integer getId() throws SQLException {
        return checkDao.getId();
    }
}
