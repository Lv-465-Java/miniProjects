package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Trip implements IEntity {

    public static enum TripQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO trips (departure_day, day_of_arrival, count_of_people, access, transport_id, user_id ) VALUES (?,?,?,?,?,?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, departure_day, day_of_arrival, count_of_people, transport_id, user_id  FROM trips WHERE id = ?"),
        GET_BY_USER_ID(SqlQueries.GET_BY_USER_ID, "SELECT id, departure_day, day_of_arrival, count_of_people, transport_id  FROM trips WHERE user_id = ?"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, departure_day, day_of_arrival, count_of_people, transport_id, user_id  FROM trips WHERE departure_day = ?"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, departure_day, day_of_arrival, count_of_people, transport_id, user_id  FROM trips WHERE access='true';"),
        GET_ALL_LIMIT(SqlQueries.GET_ALL_LIMIT, "SELECT id, departure_day, day_of_arrival, count_of_people, transport_id, user_id  FROM trips WHERE access='true' LIMIT 10;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE trips SET departure_day=?, day_of_arrival=?, count_of_people=?, access=?, transport_id=?  WHERE id = ?"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE trips SET day_of_arrival = ? WHERE id = ?"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM trips WHERE id = ?"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM trips WHERE departure_day = ?");

        private SqlQueries sqlQuery;
        private String query;

        private TripQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private LocalDate departureDay;
    private LocalDate dayOfArrival;
    private int countOfPeople;
    private boolean access;
    private Long transportId;
    private Long userId;

    public Trip(Long id, LocalDate departureDay, LocalDate dayOfArrival, int countOfPeople, Long transportId, Long userId) {
        this.id = id;
        this.departureDay = departureDay;
        this.dayOfArrival = dayOfArrival;
        this.countOfPeople = countOfPeople;
        this.transportId = transportId;
        this.userId = userId;
    }
}
