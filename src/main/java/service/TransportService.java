package service;

import entity.Transport;

import java.util.List;

public interface TransportService {

    Transport getById(Long id);

    List<Transport> getAll();

    boolean insert(Transport transport);

    boolean updateByEntity(Transport transport);

    boolean deleteById(Long id);

    boolean deleteByName(String transportName);
}
