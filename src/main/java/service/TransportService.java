package service;

import entity.Transport;

import java.util.List;

public interface TransportService {

    Transport getById(Long id);

//    List<Transport> getByField(String text);

    List<Transport> getAll();

   // List<PlaceDto> getAllLimit();


    boolean insert(Transport transport);

    boolean updateByEntity(Transport transport);

//    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

//    boolean deleteByFieldName(String fieldCondition, String textCondition);
//
//    boolean delete(Transport transport);
}
