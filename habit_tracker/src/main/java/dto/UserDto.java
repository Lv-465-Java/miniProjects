package dto;

public class UserDto {

    private long id;
    private String name;
    private String login;
    private String password;

    public UserDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserDto(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public UserDto(long id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = login;
    }

    public UserDto(long id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "(" + "id=" + getId()
                + " name=" + name +
                " login=" + login
                + " password=" + password + ")";
    }
}
