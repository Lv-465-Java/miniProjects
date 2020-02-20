package service;

import dto.PlaceDto;
import entity.Place;

import java.util.List;

public interface PlaceService {

    Place getById(Long id);

    PlaceDto getByField(String text);

    List<PlaceDto> getAll();

    List<Place> getAllFullPlaces();

    List<PlaceDto> getAllLimit();

    List<PlaceDto> getByTemplate(String template);

    boolean insert(Place place);

    boolean updateByEntity(Place place);

    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

    boolean delete(Place place);
}
