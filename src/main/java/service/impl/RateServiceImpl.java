package service.impl;

import dao.DaoCRUD;
import dao.impl.RateDaoImpl;
import entity.Rate;
import exception.Message;
import exception.NotFoundException;
import service.PlaceService;
import service.RateService;

import java.util.List;

public class RateServiceImpl implements RateService, Message {

    private DaoCRUD<Rate> daoCRUD;
    private RateService rateService;

    public RateServiceImpl() {
        daoCRUD=new RateDaoImpl();
        rateService=new RateServiceImpl();
    }


    @Override
    public List<Rate> getByFieldName(Long id) {
        List<Rate> list=daoCRUD.getByFieldName(id);

        if(list.isEmpty()){
            throw new NotFoundException(EMPTY_RATE_LIST_EXCEPTION_MESSAGE);
        } return list;
    }

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

    public Long getRateValue(Long placeId){
        List<Rate> list=rateService.getByFieldName(placeId);
        long count=list.stream().map(Rate::getValue).count();

        return (list.stream().map(Rate::getValue).mapToInt(Integer::intValue).sum())/count;

    }
}
