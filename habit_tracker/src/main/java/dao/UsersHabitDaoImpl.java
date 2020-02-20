package dao;

import dao.mapper.UsersHabitRowMapper;
import entity.UsersHabit;
import util.JdbcUtils;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UsersHabitDaoImpl implements Crud<UsersHabit> {
    private final Connection connection;

    public UsersHabitDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public int insert(UsersHabit user) {
        try {
            String ADD_USER = "INSERT INTO Users_habit(user_id, habit_id, description) VALUES(?, ? , ?);";

            return JdbcUtils.update(connection, ADD_USER, user.getUser_id(), user.getHabit_id(),user.getDescription());
        }
        catch (Exception a){return 0;}
    }

    @Override
    public List<UsersHabit> getAll() {
        try {
            String GET_ALL = "SELECT * FROM users_habit";
            return JdbcUtils.query(connection, GET_ALL, new UsersHabitRowMapper());
        }
        catch (Exception a){return null;}
    }
    @Override
    public Optional<UsersHabit> getById(long id) {
        try {
            String GET = "SELECT * FROM users_habit WHERE id = ?";
            return JdbcUtils.queryForObject(connection, GET, new UsersHabitRowMapper(),id);
        }
        catch (Exception a){return null;}
    }
    public List<UsersHabit> getByUserId(long user_id) {
        try {
            String GET = "SELECT * FROM users_habit WHERE user_id = ?";
            return JdbcUtils.query(connection, GET, new UsersHabitRowMapper(),user_id);
        }
        catch (Exception a){return null;}
    }
    public List<UsersHabit> getByHabitId(long habit_id) {
        try {
            String GET = "SELECT * FROM users_habit WHERE habit_id = ?";
            return JdbcUtils.query(connection, GET, new UsersHabitRowMapper(),habit_id);
        }
        catch (Exception a){return null;}
    }

    public Optional<UsersHabit> getid(long user_id,long habit_id) {
        try {
            String GET = "SELECT * FROM users_habit WHERE user_id = ? and habit_id = ?";
            return JdbcUtils.queryForObject(connection, GET,new UsersHabitRowMapper(),user_id, habit_id);
//                    new UsersHabitRowMapper(),user_id,habit_id);
//            if (usersHabit.isPresent()){
//                return usersHabit.get().getId();
            }
        catch (Exception a){return null;}
    }
    @Override
    public int deleteById(long id) {
        try {
            String DELETE_HABIT = "DELETE FROM users_habit WHERE id = ?";
            return JdbcUtils.update(connection, DELETE_HABIT, id);
        }
        catch (Exception a){return 0;}
    }
    public int updateById(String description,long id) {
        try {
            String UPDATE_PASS = "UPDATE users_habit SET description = ? WHERE id = ?";
            return JdbcUtils.update(connection, UPDATE_PASS, description, id);
        }
        catch (Exception a){return 0;}
    }
    @Override
    public int updateById(UsersHabit habit) {
        try {
            String UPDATE_PASS = "UPDATE users_habit SET description = ? WHERE id = ?";
            return JdbcUtils.update(connection, UPDATE_PASS, habit.getDescription(), habit.getId());
        }
        catch (Exception a){return 0;}
    }
//    public Optional<Object> get_all_habit_info(long users_habit_id){
//        try{
//            String GET_ALL_INFO="select habit.name , users_habit.description , habit_strike.do_date +" +
//                    "from habit inner join users_habit on habit.id=users_habit.habit_id +" +
//                    "inner join habit_strike on users_habit.id=habit_strike.users_habit_id +" +
//                    "where users_habit.id= ? ";
//            return JdbcUtils.update(connection, GET_ALL_INFO, users_habit_id);
//        }
//    }


}
