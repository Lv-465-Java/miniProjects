package entity;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class User implements IEntity {

    public static enum UserQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO users (first_name,last_name, username, email, password) VALUES (?,?,?,?,?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, first_name, last_name, username, email, role FROM users WHERE id = ?"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, first_name, last_name, username, email, role FROM users WHERE username = ?"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, first_name, last_name, username, email, role FROM users;"),
        GET_ALL_LIMIT(SqlQueries.GET_ALL_LIMIT, "SELECT id, first_name, last_name, username, email, role FROM users LIMIT 10;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET first_name = ?, last_name = ?, username=?, email= ?, password=? WHERE id = ?"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET email = ? WHERE username = ?"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM users WHERE id = ? ");
       // DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM users WHERE username = ?");

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


//    public static String generateHashPassword(String password){
//
//       char icon1;
//       char[] t=new char[20];
//       int random = (int)(Math.random()*6)+38;
//       icon1=password.charAt(random);
//       int i=0;
//       while (i<11){
//           int random1=(int)(Math.random()*password.length());
//
//           t[i]=password.charAt(random1);
//           i++;
//           t[10]=icon1;
//       }
//       return new String(t);
//    }


    /**
     * Generate hash password.
     *
     * @param usrDto User dto.
     * @param salt Password salt.
     *
     * @return String salt of password.
     */
//    private String generateHashPassword(UsrDto usrDto, String salt){
//        String resultPass = salt + usrDto.getPassword();
//        try {
//            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//            byte[] hash = messageDigest.digest(resultPass.getBytes(StandardCharsets.US_ASCII));
//            return (new String(hash, StandardCharsets.US_ASCII));
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
