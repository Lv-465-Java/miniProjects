package service.implementation;

import dao.HabitDaoImpl;
import dao.HabitStrikeDaoImpl;
import dao.UsersHabitDaoImpl;
import dto.AllHabitInfoDto;
import dto.CreateHabitDto;
import entity.Habit;
import entity.HabitStrike;
import entity.UsersHabit;
import exeption.NotDeletedException;
import exeption.NotSavedException;
import exeption.NotUpdatedException;
import util.ConnectionUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.*;

public class HabitService {
    private Connection con;
    private UsersHabitDaoImpl usersHabitDao;
    private HabitDaoImpl habitDao;
    private HabitStrikeDaoImpl habitStrikeDao;

    public HabitService() {
        try {
            con = ConnectionUtils.getConnection();
            usersHabitDao = new UsersHabitDaoImpl(con);
            habitDao = new HabitDaoImpl(con);
            habitStrikeDao = new HabitStrikeDaoImpl(con);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public HabitService(Connection con) {
        this.con = con;
        usersHabitDao = new UsersHabitDaoImpl(con);
        habitDao = new HabitDaoImpl(con);
        habitStrikeDao = new HabitStrikeDaoImpl(con);

    }

    public Map<String, String> create_habit(CreateHabitDto createHabitDto) {
        Map<String, String> error = new HashMap<>();
        if (isBlank(createHabitDto.getName())) {
            error.put("name", "Habit name should not be null");
            return error;
        }
        long habit_id = get_id_by_name(createHabitDto);
        if (habit_id == 0) {
            habitDao.insert(new Habit(createHabitDto.getName()));
        }
        if (get_users_habit_id(createHabitDto.getUser_id(), habit_id) != 0) {
            error.put("exist", "You already have this habit");
            return error;
        } else {
            UsersHabit usersHabit = new UsersHabit(createHabitDto.getUser_id(),
                    get_id_by_name(createHabitDto),
                    createHabitDto.getDescription());
            if (usersHabitDao.insert(usersHabit) == 0) {
                throw new NotSavedException("Habit is not saved");
            }

        }
        return error;

    }

    private boolean isBlank(String name) {
        if (name.isBlank()) {
            return true;
        } else return false;
    }

    public long get_id_by_name(CreateHabitDto createHabitDto) {
        Optional<Habit> habit = habitDao.getByName(createHabitDto.getName());
        System.out.println(habit);

        if (habit.isPresent()) {
            return habit.get().getId();
        } else return 0;
    }

    public boolean do_habit(long user_id, long habit_id) {
        long id = get_users_habit_id(user_id, habit_id);
        if (habitStrikeDao.insert(new HabitStrike(id, (new Date(Calendar.getInstance().getTime().getTime())))) != 0)
            return true;
        else {
            throw new NotSavedException("Date was't saved");
        }

    }

    public boolean delete_habit(long user_id, long habit_id) {
        boolean users_with_same_habit = false;
        try {
            long id = get_users_habit_id(user_id, habit_id);
            if (id != 0) {
                if (usersHabitDao.deleteById(id) != 0) {
                    List<UsersHabit> all = usersHabitDao.getByHabitId(habit_id);
                    for (UsersHabit user : all) {
                        if (user.getUser_id() != user_id) {
                            users_with_same_habit = true;
                        } else users_with_same_habit = false;
                    }
                    if (users_with_same_habit == false) {
                        habitDao.deleteById(habit_id);
                    }
                }
                return true;
            } else return false;
        } catch (RuntimeException e) {
            throw new NotDeletedException("Habit was not deleted");
        }
    }

    public AllHabitInfoDto getAllInfo(long user_id, long habit_id) {
        long users_habit_id = get_users_habit_id(user_id, habit_id);
        List<Date> all_date = getAllDoDate(users_habit_id);
        List<Integer> all_days = get_all_do_days(all_date);
        return new AllHabitInfoDto(getHabitNameById(habit_id),
                getDescription(users_habit_id),
                all_days, all_date.size(), getFirstDate(users_habit_id), getBestStrike(user_id, habit_id));
    }

    public Date getFirstDate(long users_habit_id) {
        List<Date> date = getAllSortedDates(users_habit_id);
        if (date.size() >= 1) {
            return date.get(0);
        } else return null;
    }

    public List<Date> getAllSortedDates(long users_habit_id) {
        return habitStrikeDao.getAllDates(users_habit_id);
    }

    private List<Integer> get_all_do_days(List<Date> all_date) {
        List<Integer> all_days = new ArrayList<>();
        int year = YearMonth.now().getYear();
        int month = YearMonth.now().getMonthValue();
        for (Date day : all_date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(day);
            int yaer2 = calendar.get(Calendar.YEAR);
            int month2 = calendar.get(Calendar.MONTH) + 1;
            if (yaer2 == year && month2 == month) {
                all_days.add(calendar.get(Calendar.DAY_OF_MONTH));
            }
        }
        return all_days;
    }

    public String getHabitNameById(long habit_id) {
        Optional<Habit> habit = habitDao.getById(habit_id);
        if (habit.isPresent()) {
            return habit.get().getName();
        } else return null;
    }

    public String getDescription(long users_habit_id) {
        Optional<UsersHabit> info = usersHabitDao.getById(users_habit_id);
        if (info.isPresent()) {
            return info.get().getDescription();
        } else return null;
    }

    public List<Date> getAllDoDate(long users_habit_id) {
        List<Date> all_date = new ArrayList<>();
        List<HabitStrike> all_info = new HabitStrikeDaoImpl(con).getByUsershabitId(users_habit_id);
        for (HabitStrike info : all_info) {
            all_date.add(info.getDo_date());
        }
        return all_date;
    }

    public int getBestStrike(long user_id, long habit_id) {
        long users_habit_id = get_users_habit_id(user_id, habit_id);
        List<Date> all_date = getAllSortedDates(users_habit_id);
//        if (all_date.size() < 2) {
//            return 1;
//        } else {
        int maxStrike;
        int strike = 1;
        maxStrike = strike;
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < all_date.size() - 1; i++) {
            calendar.setTime(all_date.get(i));
            calendar.add(Calendar.DATE, 1);
            Date nextDay = (Date) calendar.getTime();
            if (nextDay.equals(all_date.get(i + 1))) {
                strike++;
            } else {
                maxStrike = strike;
                strike = 1;
            }
        }
        return maxStrike;
    }

    public boolean is_habit_done(long users_habit_id) {
        return isDataValid(users_habit_id);

    }

    public long get_users_habit_id(long user_id, long habit_id) {
        Optional<UsersHabit> user_habit = usersHabitDao.getid(user_id, habit_id);
        if (user_habit.isPresent()) {
            return user_habit.get().getId();
        } else return 0;
    }

    public boolean isDataValid(long users_habit_id) {
        Optional<HabitStrike> habit_strike = habitStrikeDao.getIfValids(users_habit_id);
        if (habit_strike.isPresent()) {
            return true;
        } else return false;
    }


    public boolean editDescription(String description, long user_id, long habit_id) {
        try {
            if (usersHabitDao.updateById(description, get_users_habit_id(user_id, habit_id)) != 0) {

                return true;
            } else return false;
        } catch (RuntimeException e) {
            throw new NotUpdatedException("Description is not updated");
        }

    }
}



