package service.impl;

import dao.impl.RateDaoImpl;
import entity.Rate;
import exception.Message;
import exception.NotFoundException;
import service.RateService;

import java.util.List;

public class RateServiceImpl implements RateService, Message {

    private RateDaoImpl rateDao;

    public RateServiceImpl() {
        rateDao=new RateDaoImpl();
    }


    @Override
    public List<Rate> getByFieldName(Long id) {
        List<Rate> list=rateDao.getByFieldName(id);

        if(list.isEmpty()){
            throw new NotFoundException(EMPTY_RATE_LIST_EXCEPTION_MESSAGE);
        } return list;
    }

    @Override
    public List<Rate> getAll() {
        List<Rate> list=rateDao.getAll();

        if(list.isEmpty()){
            throw new NotFoundException(EMPTY_RATE_LIST_EXCEPTION_MESSAGE);
        } return list;
    }

    @Override
    public boolean insert(Rate rate) {
        if(rateDao.insert(rate)){
            return true;
        } else {
            throw new NotFoundException(CREATE_RATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(Rate rate) {
        if (rateDao.updateByEntity(rate)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_RATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(rateDao.deleteById(id)){
            return true;
        } else {
            throw new NotFoundException(DELETE_RATE_EXCEPTION_MESSAGE);
        }
    }

    public Long getRateValue(Long placeId){
        List<Rate> list=rateDao.getByFieldName(placeId);
        long count=list.stream().map(Rate::getValue).count();

        return (list.stream().map(Rate::getValue).mapToInt(Integer::intValue).sum())/count;

    }
}
