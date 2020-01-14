package com.auto.service.impl;

import com.auto.dao.impl.CarDaoImpl;
import com.auto.dao.impl.CheckDaoImpl;
import com.auto.dao.impl.ClientDaoImpl;
import com.auto.dto.CheckDto;
import com.auto.dto.mapper.CheckDtoMapper;
import com.auto.model.Check;
import com.auto.service.CheckService;

import java.sql.SQLException;
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
