package dao.mapper;

import entity.Habit;
import entity.HabitStrike;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HabitStrikeRowMapper implements RowMapper<HabitStrike> {
    @Override
    public HabitStrike mapRow(ResultSet resultSet) {
        HabitStrike habit = new HabitStrike();
        try {
            habit.setId(resultSet.getLong("id"));
            habit.setUsers_habit_id(resultSet.getLong("users_habit_id"));
            habit.setDo_date(resultSet.getDate("do_date"));
            return habit;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
