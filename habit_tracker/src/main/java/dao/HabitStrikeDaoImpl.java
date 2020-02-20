package dao;

import dao.mapper.HabitRowMapper;
import dao.mapper.HabitStrikeRowMapper;
import dao.mapper.UsersHabitRowMapper;
import entity.HabitStrike;
import entity.UsersHabit;
import util.ConnectionUtils;
import util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class HabitStrikeDaoImpl implements Crud<HabitStrike> {
    private final Connection connection;

    public HabitStrikeDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public int insert(HabitStrike habit) {
        try {
            String ADD_HABIT = "INSERT INTO HABIT_STRIKE(users_habit_id, do_date) VALUES(?,?)";
            return JdbcUtils.update(connection, ADD_HABIT, habit.getUsers_habit_id(),habit.getDo_date());
        }
        catch (Exception a){return 0;}
    }
    @Override
    public List<HabitStrike> getAll() {
        try {
            String GET_ALL = "SELECT * FROM habit_strike";
            return JdbcUtils.query(connection, GET_ALL, new HabitStrikeRowMapper());
        }
        catch (Exception a){return null;}
    }

    public Optional<HabitStrike> getIfValids(long users_habit_id) {
        try {
            String GET_ALL = "SELECT * FROM habit_strike where users_habit_id = ? and do_date = curdate() ";
            return JdbcUtils.queryForObject(connection, GET_ALL, new HabitStrikeRowMapper(),users_habit_id);
        }
        catch (Exception a){return null;}
    }

    public List<HabitStrike> getByUsershabitId(long users_habit_id) {
        try {
            String GET = "SELECT * FROM habit_strike WHERE users_habit_id = ?";
            return JdbcUtils.query(connection, GET, new HabitStrikeRowMapper(),users_habit_id);
        }
        catch (Exception a){return null;}
    }

    @Override
    public Optional<HabitStrike> getById(long id) {
        try {
            String GET = "SELECT * FROM habit_strike WHERE id = ? ";
            return JdbcUtils.queryForObject(connection, GET, new HabitStrikeRowMapper(),id);
        }
        catch (Exception a){return null;}
    }
    public List<Date> getAllDates(long users_habit_id){
        try {
            List<Date> all_date = new ArrayList<>();
            String GET = "select * from habit_strike where users_habit_id= ? order by do_date";
            List<HabitStrike> habitStrikes = JdbcUtils.query(connection, GET, new HabitStrikeRowMapper(), users_habit_id);
            for (HabitStrike h : habitStrikes) {
                all_date.add(h.getDo_date());
            }
            return all_date;
        } catch (Exception a){return null;}
        }

    @Override
    public int deleteById(long id) {
        try {
            String DELETE_HABIT = "DELETE FROM habit_strike WHERE id = ?";
            return JdbcUtils.update(connection, DELETE_HABIT, id);
        }
        catch (Exception a){return 0;}
    }

    @Override
    public int updateById(HabitStrike habit) {
        try {
            String UPDATE_PASS = "UPDATE habit_strike SET do_date = ? WHERE id = ?";
            return JdbcUtils.update(connection, UPDATE_PASS, habit.getDo_date(), habit.getId());
        }
        catch (Exception a){return 0;}
    }

}
