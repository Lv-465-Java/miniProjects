package service.impl;

import dao.DaoCRUD;
import dao.impl.TransportDaoImpl;
import dto.TripDto;
import entity.Transport;
import entity.Trip;
import exception.Message;
import exception.NotFoundException;
import mapper.TripMapper;
import service.TransportService;

import java.util.List;
import java.util.stream.Collectors;

public class TransportServiceImpl implements TransportService, Message {

    private DaoCRUD<Transport> daoCRUD;

    public TransportServiceImpl() {
        daoCRUD=new TransportDaoImpl();
    }


    @Override
    public Transport getById(Long id) {

        return daoCRUD.getById(id)
                .orElseThrow(()->new NotFoundException(String.format(TRANSPORT_NOT_FOUND_EXCEPTION_MESSAGE,id)));
    }


    @Override
    public List<Transport> getAll() {
        List<Transport> list=daoCRUD.getAll();

        if(list.isEmpty()){
            throw new NotFoundException(EMPTY_TRANSPORT_LIST_EXCEPTION_MESSAGE);
        } return list;
    }

    @Override
    public boolean insert(Transport transport) {
        if(daoCRUD.insert(transport)){
            return true;
        } else {
            throw  new NotFoundException(CREATE_TRANSPORT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(Transport transport) {
        if (daoCRUD.updateByEntity(transport)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_TRANSPORT_EXCEPTION_MESSAGE);
        }
    }


    @Override
    public boolean deleteById(Long id) {
        if(daoCRUD.deleteById(id)){
            return true;
        } else {
            throw new NotFoundException(DELETE_TRANSPORT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteByName(String transportName) {
        if(daoCRUD.deleteByFieldName(transportName)){
            return true;
        } else {
            throw new NotFoundException(DELETE_TRANSPORT_EXCEPTION_MESSAGE);
        }
    }
}
