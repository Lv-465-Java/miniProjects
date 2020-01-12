package service.impl;

import dao.DaoCRUD;
import dao.impl.RateDaoImpl;
import entity.Rate;
import exception.Message;
import exception.NotFoundException;
import service.RateService;

import java.util.List;

public class RateServiceImpl implements RateService, Message {

    private DaoCRUD<Rate> daoCRUD;

    public RateServiceImpl() {
        daoCRUD=new RateDaoImpl();
    }

//    @Override
//    public RateDto getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<RateDto> getByField(String text) {
//        return null;
//    }

    @Override
    public List<Rate> getAll() {
        List<Rate> list=daoCRUD.getAll();

        if(list.isEmpty()){
            throw new NotFoundException(EMPTY_RATE_LIST_EXCEPTION_MESSAGE);
        } return list;
    }

    @Override
    public boolean insert(Rate rate) {
        if(daoCRUD.insert(rate)){
            return true;
        } else {
            throw new NotFoundException(CREATE_RATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(Rate rate) {
        if (daoCRUD.updateByEntity(rate)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_RATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(daoCRUD.deleteById(id)){
            return true;
        } else {
            throw new NotFoundException(DELETE_RATE_EXCEPTION_MESSAGE);
        }
    }

//    @Override
//    public boolean delete(Rate rate) {
//        return false;
//    }
}
