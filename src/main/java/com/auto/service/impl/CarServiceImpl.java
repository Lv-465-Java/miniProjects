package com.auto.service.impl;

import com.auto.dao.impl.CarDaoImpl;
import com.auto.dto.CarDto;
import com.auto.dto.mapper.CarDtoMapper;
import com.auto.model.Car;
import com.auto.service.CarService;

import java.sql.SQLException;
import java.util.List;


public class CarServiceImpl implements CarService {
    private CarDaoImpl carDao;
    private CarDtoMapper carDtoMapper;

    public CarServiceImpl() {
        carDao = new CarDaoImpl();
        carDtoMapper = new CarDtoMapper();
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = carDao.getAll();
        return cars;
    }

    @Override
    public Car findById(Integer id) throws SQLException {
        return carDao.findById(id);
    }

    @Override
    public void create(CarDto entity) {
        try {
            carDao.create(carDtoMapper.convertFromDto(entity));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Car entity) throws SQLException {
    carDao.update(entity);
    }
    
    public Integer getId() {
        int id = 0;
        try {
            id = carDao.getId()+1;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public void delete(Integer id) throws SQLException {
    carDao.delete(id);
    }
    public List<Car> getByField(String field){
        return carDao.getByField(field);
    }

}
