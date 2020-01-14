package service.impl;

import dao.TripPlaceDao;
import dao.impl.TripPlaceDaoImpl;
import entity.TripPlace;
import exception.Message;
import exception.NotFoundException;
import service.TripPlaceService;

import java.util.List;

public class TripPlaceServiceImpl implements TripPlaceService, Message {

    private TripPlaceDao tripPlaceDao;

    public TripPlaceServiceImpl() {
        tripPlaceDao=new TripPlaceDaoImpl();
    }

    @Override
    public TripPlace getByTwoId(Long tripId, Long placeId) {
        return tripPlaceDao.getByTwoId(tripId,placeId)
                .orElseThrow(()-> new NotFoundException(String.format(TRIP_PLACE_NOT_FOUND_EXCEPTION_MESSAGE,tripId,placeId)));
    }

    @Override
    public List<TripPlace> getByTripId(Long tripId) {
        List<TripPlace> list=tripPlaceDao.getByTripId(tripId);
        if(list.isEmpty()){
            throw new NotFoundException(String.format(TRIP_NOT_FOUND_PLACES_EXCEPTION_MESSAGE,tripId));
        }
            return list;
    }

    @Override
    public List<TripPlace> getAll() {
        List<TripPlace> list=tripPlaceDao.getAll();
        if(list.isEmpty()){
            throw new NotFoundException(EMPTY_TRIP_PLACE_LIST_EXCEPTION_MESSAGE);
        }
        return list;
    }

    @Override
    public boolean insert(TripPlace tripPlace) {
        if(tripPlaceDao.insert(tripPlace)){
            return true;
        } else {
            throw new NotFoundException(CREATE_TRIP_PLACE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByField(Long tripId, Long placeId) {
        if(tripPlaceDao.updateByField(tripId,placeId)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_TRIP_PLACE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteByTwoId(Long tripId, Long placeId) {
        if(tripPlaceDao.deleteByTwoId(tripId,placeId)){
            return true;
        } else {
            throw new NotFoundException(DELETE_TRIP_PLACE_EXCEPTION_MESSAGE);
        }
    }

    public boolean isEmptyPlaceList( Long tripId){
        List<TripPlace> list=getByTripId(tripId);
        if(list.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
