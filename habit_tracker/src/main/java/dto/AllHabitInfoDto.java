package dto;

import java.sql.Date;
import java.util.List;

public class AllHabitInfoDto {
    private String name;
    private String description;
    private List<Integer> do_date;
    private int amount_of_do_date;
    private Date first_date;
    private int habit_strike;

    public AllHabitInfoDto(String name, String description, List<Integer> do_date, int amount_of_do_date, Date first_date, int habit_strike) {
        this.name = name;
        this.description = description;
        this.do_date = do_date;
        this.amount_of_do_date = amount_of_do_date;
        this.first_date = first_date;
        this.habit_strike = habit_strike;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDo_date(List<Integer> do_date) {
        this.do_date = do_date;
    }

    public void setAmount_of_do_date(int amount_of_do_date) {
        this.amount_of_do_date = amount_of_do_date;
    }

    public void setFirst_date(Date first_date) {
        this.first_date = first_date;
    }

    public void setHabit_strike(int habit_strike) {
        this.habit_strike = habit_strike;
    }

    public int getAmount_of_do_date() {
        return amount_of_do_date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Integer> getDo_date() {
        return do_date;
    }

    public Date getFirst_date() {
        return first_date;
    }

    public int getHabit_strike() {
        return habit_strike;
    }

    @Override
    public String toString() {
        return "(" + "name=" + name
                + " description=" + description
                + " do_date=" + do_date
                + " amount_of_do_date =" + amount_of_do_date +
                " first_date =" + first_date +
                " habit_strike =" + habit_strike

                + ")";
    }
}
