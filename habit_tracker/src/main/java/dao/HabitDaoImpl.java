package dao;

import dao.mapper.HabitRowMapper;
import entity.Habit;
import util.JdbcUtils;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class HabitDaoImpl implements Crud<Habit> {
    private final Connection connection;

    public HabitDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public int insert(Habit habit) {
        try {
            String ADD_HABIT = "INSERT INTO HABIT(name) VALUES(?);";
            return JdbcUtils.update(connection, ADD_HABIT, habit.getName());
        }
        catch (Exception a){return 0;}
    }
    @Override
    public List<Habit> getAll() {
        try {
            String GET_ALL = "SELECT * FROM habit";
            return JdbcUtils.query(connection, GET_ALL, new HabitRowMapper());
        }
        catch (Exception a){return null;}
    }
    @Override
    public Optional<Habit> getById(long id) {
        try {
            String GET = "SELECT * FROM habit WHERE id = ?";
            return JdbcUtils.queryForObject(connection, GET, new HabitRowMapper(),id);
        }
        catch (Exception a){return null;}
    }


    public Optional<Habit> getByName(String name) {
        try {
            String GET = "SELECT * FROM habit WHERE name = ?";
            return JdbcUtils.queryForObject(connection, GET, new HabitRowMapper(),name);
        }
        catch (Exception a){return null;}
    }
    @Override
    public int deleteById(long id) {
        try {
            String DELETE_HABIT = "DELETE FROM habit WHERE id = ? ";
            return JdbcUtils.update(connection, DELETE_HABIT, id);
        }
        catch (Exception a){return 0;}
    }
    @Override
    public int updateById(Habit habit) {
        try {
            String UPDATE_PASS = "UPDATE habit SET name = ? WHERE id = ?";
            return JdbcUtils.update(connection, UPDATE_PASS, habit.getName(), habit.getId());
        }
        catch (Exception a){return 0;}
    }
}
