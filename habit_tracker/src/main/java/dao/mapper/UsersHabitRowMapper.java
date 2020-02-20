package dao.mapper;

import entity.User;
import entity.UsersHabit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersHabitRowMapper implements RowMapper<UsersHabit> {
    @Override
    public UsersHabit mapRow(ResultSet resultSet) {
        UsersHabit user = new UsersHabit();

        try {
            user.setId(resultSet.getLong("id"));
            user.setUser_id(resultSet.getInt("user_id"));
            user.setHabit_id(resultSet.getLong("habit_id"));
            user.setDescription(resultSet.getString("description"));
            return user;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
