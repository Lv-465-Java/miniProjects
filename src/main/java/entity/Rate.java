package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Rate implements IEntity{

    public static enum RateQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO rates (value, user_id, place_id) VALUES (?, ?, ?)"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, value, user_id, place_id FROM rates;"),
        GET_BY_FIELD_NAME(SqlQueries.GET_BY_FIELD_NAME, "SELECT id, value, user_id, place_id FROM rates WHERE place_id = ?"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE rates SET value = ?, place_id = ? WHERE id = ?"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM rates WHERE id = ?");

        private SqlQueries sqlQuery;
        private String query;

        private RateQueries(SqlQueries sqlQuery, String query) {
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
    private int value;
    private Long userId;
    private Long placeId;
}
