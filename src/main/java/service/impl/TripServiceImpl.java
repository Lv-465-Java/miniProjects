package service.impl;

import dao.DaoCRUD;
import dao.impl.TripDaoImpl;
import dto.TripDto;
import entity.Place;
import entity.Trip;
import exception.Message;
import exception.NotFoundException;
import mapper.TripMapper;
import service.TransportService;
import service.TripService;

import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;


public class TripServiceImpl implements TripService, Message {

    private  DaoCRUD<Trip> daoCRUD;
    private  TransportService transportService;

    public TripServiceImpl() {
        daoCRUD=new TripDaoImpl();
        transportService=  new TransportServiceImpl();
    }

    @Override
    public TripDto getById(Long id) {
        Trip trip=daoCRUD.getById(id)
                .orElseThrow(()->new NotFoundException(String.format(TRIP_NOT_FOUND_EXCEPTION_MESSAGE,id)));

        return TripMapper.getTripDto(trip);
    }

    @Override
    public TripDto getByField(String text) {
        Trip trip = daoCRUD.getByField(text)
                .orElseThrow(()-> new NotFoundException(String.format(TRIP_DATE_NOT_FOUND_EXCEPTION_MESSAGE,text)));

        return TripMapper.getTripDto(trip);
    }

    @Override
    public List<TripDto> getAll() {
        List<Trip> list=daoCRUD.getAll();

        List<TripDto> tripDtoList= list.stream()
                .map(TripMapper::getTripDto)
                .collect(Collectors.toList());

        if(tripDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_TRIP_LIST_EXCEPTION_MESSAGE);
        } return tripDtoList;
    }

    @Override
    public List<TripDto> getAllLimit() {
        List<Trip> list=daoCRUD.getAllLimit();

        List<TripDto> tripDtoList= list.stream()
                .map(TripMapper::getTripDto)
                .collect(Collectors.toList());

        if(tripDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_TRIP_LIST_EXCEPTION_MESSAGE);
        } return tripDtoList;
    }

    @Override
    public List<TripDto> getByUserId(Long userId) {
        List<Trip> list=daoCRUD.getByUserId(userId);

        List<TripDto> tripDtoList= list.stream()
                .map(TripMapper::getTripDto)
                .collect(Collectors.toList());

        if(tripDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_TRIP_LIST_EXCEPTION_MESSAGE);
        } return tripDtoList;
    }

    @Override
    public boolean insert(Trip trip) {
        if(daoCRUD.insert(trip)){
            return true;
        } else {
            throw new NotFoundException(CREATE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(Trip trip) {
        if(daoCRUD.updateByEntity(trip)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByField(String text, String textCondition) {
        if(daoCRUD.updateByField(text, textCondition)){
            return  true;
        }  else {
            throw new NotFoundException(UPDATE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(daoCRUD.deleteById(id)){
            return true;
        } else {
            throw new NotFoundException(DELETE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteByFieldName(String textCondition) {
        if(daoCRUD.deleteByFieldName(textCondition)){
            return true;
        } else {
            throw new NotFoundException(DELETE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean delete(Trip trip) {
        if(daoCRUD.delete(trip)){
            return true;
        } else {
            throw new NotFoundException(DELETE_TRIP_EXCEPTION_MESSAGE);
        }
    }


//    public double getPrice(Trip trip){
//        Place place=new Place();
//
//        return place.getPrice()*transportService.getById(trip.getTransportId()).getTransportName().getCoefficient()
//                *trip.getCountOfPeople()
//                * Period.between(trip.getDepartureDay(),trip.getDayOfArrival()).getDays();
//    }
}
