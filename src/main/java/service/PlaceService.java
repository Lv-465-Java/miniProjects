package service;

import dto.PlaceDto;
import dto.PlaceWithPhotoDto;
import entity.Place;

import java.util.List;

public interface PlaceService {

    PlaceDto getById(Long id);

    PlaceDto getByField(String text);

    List<PlaceDto> getAll();

    List<PlaceDto> getAllLimit();


    boolean insert(Place place);

    boolean updateByEntity(Place place);

    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

    //boolean deleteByFieldName(String textCondition);

    boolean delete(Place place);
}
