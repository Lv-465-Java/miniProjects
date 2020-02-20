package dto;

public class HabitDto {
    private long id;
    private String name;
    private boolean isDoneToday;
    private int do_date;
    private int habit_strike;

    public HabitDto(long id, String name, boolean isDoneToday, int do_date, int habit_strike) {
        this.id = id;
        this.name = name;
        this.isDoneToday = isDoneToday;
        this.do_date = do_date;
        this.habit_strike = habit_strike;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsDoneToday(boolean isDoneToday) {
        this.isDoneToday = isDoneToday;
    }

    public void setDo_date(int do_date) {
        this.do_date = do_date;
    }

    public void setHabit_strike(int habit_strike) {
        this.habit_strike = habit_strike;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getIsDoneToday() {
        return isDoneToday;
    }

    public int getDo_date() {
        return do_date;
    }

    public int getHabit_strike() {
        return habit_strike;
    }

    @Override
    public String toString() {
        return "(" + "id=" + id
                + " name=" + name
                + " is done today =" + isDoneToday
                + " do_date =" + do_date
                + " habit_strike =" + habit_strike
                + ")";
    }
}
