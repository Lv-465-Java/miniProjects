package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Transport implements IEntity{

    public static enum TransportQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO transports (name) VALUES (?)"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name FROM transports;"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name FROM transports WHERE id = ?"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE transports SET name = ? WHERE id = ?"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM transports WHERE id = ?"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM transports WHERE name = ?");

        private SqlQueries sqlQuery;
        private String query;

        private TransportQueries(SqlQueries sqlQuery, String query) {
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
    //private TransportName transportName;
    private String transportName;
}
