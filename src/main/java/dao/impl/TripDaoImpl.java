package dao.impl;

import entity.*;
import entity.Trip.TripQueries;

import java.time.LocalDate;

public class TripDaoImpl extends DaoCRUDAbsImpl<Trip> {

        public TripDaoImpl() {
            super();
            init();
        }

        protected void init() {
            for (TripQueries tripQueries : Trip.TripQueries.values()) {
                sqlQueries.put(tripQueries.getSqlQuery(), tripQueries);
            }
        }

        protected Trip createInstance(String[] args) {
            return new Trip(
                    Long.parseLong(args[0] == null ? "0" : args[0]),
                    LocalDate.parse(args[1] == null ? LocalDate.now().toString() : args[1]),
                    LocalDate.parse(args[2] == null ? LocalDate.now().toString() : args[2]),
                    Integer.parseInt(args[3] == null ? "0" : args[3]),
                    Long.parseLong(args[4] == null ? "0" : args[4]),
                    Long.parseLong(args[5] == null ? "0" : args[5])
            );
        }

        protected String[] getUpdateFields(Trip trip) {
            String[] result = new String[6];
            String[] allFields = getFields(trip);

            result[0] = allFields[0];
            result[1] = allFields[1];
            result[2] = allFields[2];
            result[3] = allFields[3];
            result[4] = allFields[4];
            result[5] = trip.getId().toString();
            return result;
        }

        protected String[] getFields(Trip trip) {

            String[] fields = new String[6];

            fields[0] = trip.getDepartureDay().toString();
            fields[1] = trip.getDayOfArrival().toString();
            fields[2] = String.valueOf(trip.getCountOfPeople());
            fields[3] = String.valueOf(trip.isAccess()? 1:0);
            fields[4] = trip.getTransportId().toString();
            fields[5] = trip.getUserId().toString();
            return fields;
        }
}
