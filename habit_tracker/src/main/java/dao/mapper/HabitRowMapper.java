package dao.mapper;

import entity.Habit;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HabitRowMapper implements RowMapper<Habit> {
    @Override
    public Habit mapRow(ResultSet resultSet) {
        Habit habit = new Habit();
        try {
            habit.setId(resultSet.getLong("id"));
            habit.setName(resultSet.getString("name"));
            return habit;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
