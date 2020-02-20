package dto;

public class CreateHabitDto {
    private long user_id;
    private long habit_id;
    private String name;
    private String description;

    public CreateHabitDto(long user_id, String name, String description) {
        this.user_id = user_id;
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setHabit_id(long habit_id) {
        this.habit_id = habit_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getHabit_id() {
        return habit_id;
    }

    public long getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "(" + "name=" + name
                + " description=" + description
                + ")";
    }
}
