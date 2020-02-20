package service;

import dto.TripDto;
import entity.Trip;

import java.util.List;

public interface TripService {

    Trip getById(Long id);

    TripDto getByField(String text);

    List<TripDto> getAll();

    List<TripDto> getAllLimit();

    List<TripDto> getByUserId(Long userId);

    boolean insert(Trip trip);

    boolean updateByEntity(Trip trip);

    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

    boolean deleteByFieldName(String textCondition);

    boolean delete(Trip trip);
}
