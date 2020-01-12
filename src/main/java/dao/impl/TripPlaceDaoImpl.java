package dao.impl;

import dao.TripPlaceDao;
import db.ConnectionManager;
import entity.TripPlace;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TripPlaceDaoImpl implements TripPlaceDao {

    public final String INSERT_QUERY="INSERT INTO trips_has_places (trip_id, place_id ) VALUES (?,?)";
    public final String GET_BY_TWO_ID="SELECT trip_id, place_id  FROM trips_has_places WHERE trip_id = ? AND place_id=?";
    public final String GET_ALL="SELECT trip_id, place_id  FROM trips_has_places";
    public final String UPDATE_QUERY="UPDATE trips_has_places SET place_id=?  WHERE trip_id = ?";
    public final String GET_BY_TRIP_ID="SELECT trip_id, place_id  FROM trips_has_places WHERE trip_id = ?";
    public final String DELETE_QUERY="DELETE FROM trips_has_places WHERE trip_id = ? and place_id=?";


    @Override
    public Optional<TripPlace> getByTwoId(Long tripId, Long placeId) {

        TripPlace tripPlace;
        try {
            PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(GET_BY_TWO_ID);

            statement.setLong(1, tripId);
            statement.setLong(2, placeId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Long idTrip= resultSet.getLong("trip_id");
                Long idPlace = resultSet.getLong("place_id");

                tripPlace = new TripPlace(idTrip,idPlace);
               return Optional.of(tripPlace);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TripPlace> getByTripId(Long tripId) {
        List<TripPlace> tripPlaceList=new ArrayList<>();
            try {
                PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(GET_BY_TRIP_ID);

                statement.setLong(1, tripId);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Long idTrip= resultSet.getLong("trip_id");
                    Long idPlace = resultSet.getLong("place_id");

                    TripPlace tripPlace = new TripPlace(idTrip,idPlace);
                    tripPlaceList.add(tripPlace);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return tripPlaceList;
        }

    @Override
    public List<TripPlace> getAll() {
        List<TripPlace> tripPlaceList=new ArrayList<>();
        try {
            PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(GET_ALL);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long idTrip= resultSet.getLong("trip_id");
                Long idPlace = resultSet.getLong("place_id");

                TripPlace tripPlace = new TripPlace(idTrip,idPlace);
                tripPlaceList.add(tripPlace);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tripPlaceList;
    }

    @Override
    public boolean insert(TripPlace tripPlace) {
        boolean result=false;
        try {
            PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(INSERT_QUERY);

            statement.setLong(1, tripPlace.getTripId());
            statement.setLong(2, tripPlace.getPlaceId());

            result= statement.executeUpdate()>0 ? Boolean.TRUE : Boolean.FALSE;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateByField(Long tripId, Long placeId) {
        boolean result=false;
        try {
            PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(UPDATE_QUERY);

            statement.setLong(1, tripId);
            statement.setLong(2, placeId);

            result= statement.executeUpdate()>0 ? Boolean.TRUE : Boolean.FALSE;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteByTwoId(Long tripId, Long placeId) {
        boolean result=false;
        try {
            PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(DELETE_QUERY);

            statement.setLong(1, tripId);
            statement.setLong(2, placeId);

            result= statement.executeUpdate()>0 ? Boolean.TRUE : Boolean.FALSE;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
