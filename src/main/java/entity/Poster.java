package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Poster implements IEntity {

    @Override
    public Long getId() {
        return getUserId();
    }

    public static enum PosterQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO posters (user_id, path) VALUES (?,?)");

//
//        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET first_name = ?, last_name = ?, username=?, email= ?, password=? WHERE id = ?"),
//
        // DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM users WHERE username = ?");

        private SqlQueries sqlQuery;
        private String query;

        private PosterQueries(SqlQueries sqlQuery, String query) {
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

    private Long userId;
    private String path;
}
