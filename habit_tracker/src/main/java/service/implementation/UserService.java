package service.implementation;

import dao.HabitDaoImpl;
import dao.UserDaoImpl;
import dao.UsersHabitDaoImpl;
import dto.HabitDto;
import dto.UserDto;
import entity.Habit;
import entity.User;
import entity.UsersHabit;
import exeption.NotDeletedException;
import util.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private UserDaoImpl userDao;
    private Connection con;
    private UsersHabitDaoImpl usersHabitDao;
    private HabitDaoImpl habitDao;
    private HabitService habitService;

    public UserService() {
        try {
            con = ConnectionUtils.getConnection();
            userDao = new UserDaoImpl(con);
            usersHabitDao = new UsersHabitDaoImpl(con);
            habitDao = new HabitDaoImpl(con);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean delete_by_id(long id) {
        try {
            if (userDao.deleteById(id) != 0) {
                return true;
            } else return false;
        } catch (RuntimeException e) {
            throw new NotDeletedException("User was't deleted");
        }
    }


    public String getName(long id) {
        Optional<User> user = userDao.getById(id);
        if (user.isPresent()) {
            return user.get().getName();
        } else return null;
    }

    public int get_amount_of_all_do_date(List<HabitDto> habit) {
        int count = 0;
        for (HabitDto h : habit) {
            count += h.getDo_date();
        }
        return count;
    }

    public List<HabitDto> get_all_habit(UserDto userDto) {
        List<HabitDto> all_habit = new ArrayList<>();
        List<UsersHabit> all = usersHabitDao.getByUserId(userDto.getId());
        for (UsersHabit usersHabit : all) {
            Optional<Habit> habit = habitDao.getById(usersHabit.getHabit_id());
            habitService = new HabitService(con);
            boolean isHabitDoneToday = habitService.is_habit_done(usersHabit.getId());
            if (habit.isPresent()) {
                long users_habit_id = habitService.get_users_habit_id(userDto.getId(), habit.get().getId());
                int amount_of_do_date = habitService.getAllDoDate(users_habit_id).size();
                all_habit.add(new HabitDto(habit.get().getId(), habit.get().getName(), isHabitDoneToday,
                        amount_of_do_date, habitService.getBestStrike(userDto.getId(), habit.get().getId())
                ));

            }
        }
        return all_habit;
    }

}

