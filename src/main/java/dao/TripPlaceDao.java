package dao;

import entity.TripPlace;

import java.util.List;
import java.util.Optional;

public interface TripPlaceDao {

    Optional<TripPlace> getByTwoId(Long tripId, Long placeId);

    List<TripPlace> getByTripId(Long tripId);

    List<TripPlace> getAll();

    boolean insert(TripPlace tripPlace);

    boolean updateByField(Long tripId, Long placeId);

    boolean deleteByTwoId(Long tripId, Long placeId);
}
