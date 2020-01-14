package service;

import entity.TripPlace;

import java.util.List;

public interface TripPlaceService {

    TripPlace getByTwoId(Long tripId, Long placeId);

    List<TripPlace> getByTripId(Long tripId);

    List<TripPlace> getAll();

    boolean insert(TripPlace tripPlace);

    boolean updateByField(Long tripId, Long placeId);

    boolean deleteByTwoId(Long tripId, Long placeId);

    public boolean isEmptyPlaceList( Long tripId);
}
