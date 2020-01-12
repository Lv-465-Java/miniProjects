package service;

import entity.Rate;

import java.util.List;

public interface RateService {

//    RateDto getById(Long id);
//
//    List<RateDto> getByField(String text);

    List<Rate> getAll();

    boolean insert(Rate rate);

    boolean updateByEntity(Rate rate);

    boolean deleteById(Long id);

//    boolean delete(Rate rate);
}
