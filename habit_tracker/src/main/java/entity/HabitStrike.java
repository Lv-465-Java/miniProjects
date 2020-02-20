package entity;

import java.sql.Date;


public class HabitStrike extends Entity {
    private long users_habit_id;
    private Date do_date;

    public HabitStrike(long users_habit_id, Date do_date) {
        this.users_habit_id = users_habit_id;
        this.do_date = do_date;
    }

    public HabitStrike(long id, long users_habit_id, Date do_date) {
        super(id);
        this.users_habit_id = users_habit_id;
        this.do_date = do_date;
    }

    public HabitStrike() {

    }

    public void setDo_date(Date do_date) {
        this.do_date = do_date;
    }

    public Date getDo_date() {
        return do_date;
    }

    public void setUsers_habit_id(long users_habit_id) {
        this.users_habit_id = users_habit_id;
    }

    public long getUsers_habit_id() {
        return users_habit_id;
    }

    @Override
    public String toString() {
        return "(" + "id=" + getId()
                + " users habit id =" + users_habit_id
                + " date=" + do_date + ")";
    }

}
