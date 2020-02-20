package dao.mapper;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet) {
        User user = new User();

        try {
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setLogin(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));
            return user;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
