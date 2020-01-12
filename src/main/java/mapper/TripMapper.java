package mapper;

import dto.TripDto;
import entity.Trip;

public class TripMapper {

    public static TripDto getTripDto(Trip trip) {
        TripDto tripDto=new TripDto();
        tripDto.setId(trip.getId());
        tripDto.setDepartureDay(trip.getDepartureDay());
        tripDto.setDayOfArrival(trip.getDayOfArrival());
        tripDto.setTransportId(trip.getTransportId());
        tripDto.setCountOfPeople(trip.getCountOfPeople());
        tripDto.setUserId(trip.getUserId());

        return tripDto;
    }

    public static Trip getTripEntity(TripDto tripDto) {
        Trip trip=new Trip();
        trip.setId(tripDto.getId());
        trip.setDepartureDay(tripDto.getDepartureDay());
        trip.setDayOfArrival(tripDto.getDayOfArrival());
        trip.setCountOfPeople(tripDto.getCountOfPeople());
        trip.setAccess(true);
        trip.setTransportId(tripDto.getTransportId());
        trip.setUserId(tripDto.getUserId());

        return trip;
    }
}
