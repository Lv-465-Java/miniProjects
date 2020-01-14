package entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class User implements IEntity {

    public static enum UserQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO users (first_name,last_name, username, email, password) VALUES (?,?,?,?,?)"),
        INSERT_POSTER(SqlQueries.INSERT_POSTER, "INSERT INTO users (avatar) VALUES (?) WHERE username = ?"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, first_name, last_name, username, email, role FROM users WHERE id = ?"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, first_name, last_name, username, email, role FROM users WHERE username = ?"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, first_name, last_name, username, email, role FROM users;"),
        GET_ALL_LIMIT(SqlQueries.GET_ALL_LIMIT, "SELECT id, first_name, last_name, username, email, role FROM users LIMIT 10;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET first_name = ?, last_name = ?, username=?, email= ?, password=? WHERE id = ?"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET email = ? WHERE username = ?"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM users WHERE id = ? ");

        private SqlQueries sqlQuery;
        private String query;

        private UserQueries(SqlQueries sqlQuery, String query) {
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
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Role userRole;

    public User(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String firstName, String lastName, String username, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }
}
