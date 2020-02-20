package dto;

public class CookieDto {
    private long id;
    private String login;
    private String password;


    public CookieDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CookieDto(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "(" + "id=" + getId()
                + " login=" + login
                + " password=" + password + ")";
    }
}
