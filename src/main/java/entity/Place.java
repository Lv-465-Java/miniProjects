package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Place implements IEntity {

    public static enum PlaceQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO places (country, town, name, description, photo) VALUES (?,?,?,?,?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, country, town, name, description, photo, price FROM places WHERE id = ?"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, country, town, name, description, photo, price FROM places WHERE name = ?"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, country, town, name, description, photo, price FROM places;"),
        GET_ALL_LIMIT(SqlQueries.GET_ALL_LIMIT, "SELECT id, country, town, name, description, photo, price FROM places LIMIT 10;"),
       UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE places SET country=?, town=?, name=?, description=?, photo=? WHERE id = ?"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE places SET description = ? WHERE id = ?"),
       DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM places WHERE id = ?");
//        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM users WHERE %s = '%s';");

        private SqlQueries sqlQuery;
        private String query;

        private PlaceQueries(SqlQueries sqlQuery, String query) {
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
    private String country;
    private String town;
    private String name;
    private String description;
    private String photo;
    private final Integer price=200;
}
