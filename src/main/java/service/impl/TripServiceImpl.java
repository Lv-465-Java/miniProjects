package service.impl;

import dao.impl.TripDaoImpl;
import dto.TripDto;
import entity.Trip;
import exception.Message;
import exception.NotFoundException;
import mapper.TripMapper;
import service.TransportService;
import service.TripService;

import java.util.List;
import java.util.stream.Collectors;


public class TripServiceImpl implements TripService, Message {

    private TripDaoImpl tripDao;
    private  TransportService transportService;

    public TripServiceImpl() {
        tripDao=new TripDaoImpl();
        transportService=  new TransportServiceImpl();
    }

    @Override
    public TripDto getById(Long id) {
        Trip trip=tripDao.getById(id)
                .orElseThrow(()->new NotFoundException(String.format(TRIP_NOT_FOUND_EXCEPTION_MESSAGE,id)));

        return TripMapper.getTripDto(trip);
    }

    @Override
    public TripDto getByField(String text) {
        Trip trip = tripDao.getByField(text)
                .orElseThrow(()-> new NotFoundException(String.format(TRIP_DATE_NOT_FOUND_EXCEPTION_MESSAGE,text)));

        return TripMapper.getTripDto(trip);
    }

    @Override
    public List<TripDto> getAll() {
        List<Trip> list=tripDao.getAll();

        List<TripDto> tripDtoList= list.stream()
                .map(TripMapper::getTripDto)
                .collect(Collectors.toList());

        if(tripDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_TRIP_LIST_EXCEPTION_MESSAGE);
        } return tripDtoList;
    }

    @Override
    public List<TripDto> getAllLimit() {
        List<Trip> list=tripDao.getAllLimit();

        List<TripDto> tripDtoList= list.stream()
                .map(TripMapper::getTripDto)
                .collect(Collectors.toList());

        if(tripDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_TRIP_LIST_EXCEPTION_MESSAGE);
        } return tripDtoList;
    }

    @Override
    public List<TripDto> getByUserId(Long userId) {
        List<Trip> list=tripDao.getByUserId(userId);

        List<TripDto> tripDtoList= list.stream()
                .map(TripMapper::getTripDto)
                .collect(Collectors.toList());

        if(tripDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_TRIP_LIST_EXCEPTION_MESSAGE);
        } return tripDtoList;
    }

    @Override
    public boolean insert(Trip trip) {
        if(tripDao.insert(trip)){
            return true;
        } else {
            throw new NotFoundException(CREATE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(Trip trip) {
        if(tripDao.updateByEntity(trip)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByField(String text, String textCondition) {
        if(tripDao.updateByField(text, textCondition)){
            return  true;
        }  else {
            throw new NotFoundException(UPDATE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(tripDao.deleteById(id)){
            return true;
        } else {
            throw new NotFoundException(DELETE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteByFieldName(String textCondition) {
        if(tripDao.deleteByFieldName(textCondition)){
            return true;
        } else {
            throw new NotFoundException(DELETE_TRIP_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean delete(Trip trip) {
        if(tripDao.delete(trip)){
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
