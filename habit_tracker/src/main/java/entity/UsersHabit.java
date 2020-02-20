package entity;

public class UsersHabit extends Entity {
    private long user_id;
    private long habit_id;
    private String description;

    public UsersHabit(long id, long user_id, long habit_id, String description) {
        super(id);
        this.user_id = user_id;
        this.habit_id = habit_id;
        this.description = description;
    }

    public UsersHabit(long id, long user_id, long habit_id) {
        super(id);
        this.user_id = user_id;
        this.habit_id = habit_id;
    }

    public UsersHabit(long user_id, long habit_id) {
        this.user_id = user_id;
        this.habit_id = habit_id;
    }

    public UsersHabit(long user_id, long habit_id, String description) {
        this.user_id = user_id;
        this.habit_id = habit_id;
        this.description = description;
    }

    public UsersHabit(String description) {
        this.description = description;
    }

    public UsersHabit() {
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

    public long getUser_id() {
        return user_id;
    }

    public long getHabit_id() {
        return habit_id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "(" + "id=" + getId()
                + " user id=" + user_id
                + " habit id=" + habit_id
                + " description=" + description + ")";
    }

}
