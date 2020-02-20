package entity;

public class Habit extends Entity {

    private String name;

    public Habit() {
    }

    public Habit(String name) {
        this.name = name;
    }

    public Habit(long id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(" + "id=" + getId()
                + " name=" + name + ")";
    }

}
