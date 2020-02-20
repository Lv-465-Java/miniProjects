package service.implementation;

import dao.UserDaoImpl;
import dto.UserDto;
import entity.User;
import exeption.NotSavedException;
import exeption.NotUpdatedException;
import security.SaltGenImpl;
import service.UserSignupService;
import util.ConnectionUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class UserSignupServiceImpl implements UserSignupService {

    private SaltGenImpl saltGen;
    private UserDaoImpl userDao;
    private Connection conn;


    public UserSignupServiceImpl() {
        try {
            this.conn = ConnectionUtils.getConnection();
            userDao = new UserDaoImpl(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methods check if user exists.
     *
     * @param login User dto.
     * @return True if user exists.
     */
    private boolean exists(String login) {
        boolean exist = userDao.getByLogin(login).isPresent();
        return exist;
    }

    private boolean exists(UserDto userDto) {
        Optional<User> user = userDao.getByLogin(userDto.getLogin());
        if (user.isPresent() && user.get().getId() != userDto.getId()) {
            return true;
        } else return false;
    }

    /**
     * Methods check if name parameter is blank.
     *
     * @param userDto User dto.
     * @return True if name is blank.
     */
    private boolean BlankName(UserDto userDto) {
        if (userDto.getName().isBlank()) {
            return true;
        } else return false;
    }

    /**
     * Methods check if login parameter is blank.
     *
     * @param login User dto.
     * @return True if login is blank.
     */
    private boolean BlankLogin(String login) {
        if (login.isBlank()) {
            return true;
        } else return false;
    }

    /**
     * Method saves new user in database
     *
     * @param userDto User dto
     * @return Map with errors.
     */
    @Override
    public Map<String, String> create_user(UserDto userDto) {
        Map<String, String> error = new HashMap<>();
        if (exists(userDto.getLogin())) {
            error.put("login", "An account with such login already exists");
            return error;
        }
        if (BlankName(userDto)) {
            error.put("name", "Name value should not be blank");
            return error;
        }
        if (BlankLogin(userDto.getLogin())) {
            error.put("blanklogin", "Login value should not be blank");
            return error;
        }
        try {
            if (convertDtoToUser(userDto) != null) {
                userDao.insert(convertDtoToUser(userDto));
            }
            return error;
        } catch (RuntimeException e) {
            throw new NotSavedException("User is not created");
        }
    }

    public List<String> updateName(long id, String name) {
        List<String> error = new ArrayList<>();
        if (name.isBlank()) {
            error.add("Name value should not be blank");
            return error;
        }
        if (userDao.updateNameById(id, name) == 0) {
            throw new NotUpdatedException("Name is not updated");
        }
        return error;
    }

    public Map<String, String> update(UserDto userDto) {
        Map<String, String> error = new HashMap<>();
        String salt = getSalt(userDto);
        String password = salt + userDto.getPassword();
        if (BlankName(userDto)) {
            error.put("name", "Name value should not be blank");
        }
        if (BlankLogin(userDto.getLogin())) {
            error.put("blanklogin", "Login value should not be blank");
        }
        if (exists(userDto)) {
            error.put("login_exist", "User with this login already exist");
        }
        try {
            userDao.updateAllById(new User(userDto.getId(),
                    userDto.getName(),
                    userDto.getLogin(),
                    password));
            return error;
        } catch (RuntimeException e) {
            throw new NotUpdatedException("User's data is not updated");
        }
    }


    public String getSalt(UserDto userDto) {
        Optional<User> user = userDao.getAllById(userDto.getId());
        if (user.isPresent()) {
            return user.get().getSalt();
        } else return null;
    }

    /**
     * Generate hash password.
     *
     * @param password User dto.
     * @param salt     Password salt.
     * @return String salt of password.
     */
    private String generateHashPassword(String password, String salt) {
        String resultPass = salt + password;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(resultPass.getBytes(StandardCharsets.US_ASCII));
            return (new String(hash, StandardCharsets.US_ASCII));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert user dto to user entity.
     *
     * @param userDto User dto.
     * @return User entity.
     */
    private User convertDtoToUser(UserDto userDto) {
        User user = new User();
        String salt = new SaltGenImpl().get();
        user.setName(userDto.getName());
        user.setLogin(userDto.getLogin());
        user.setPassword(generateHashPassword(userDto.getPassword(), salt));
        user.setSalt(salt);
        return user;
    }

    public UserDto isValid(UserDto userDto) {
        Optional<User> user = userDao.getByLogin(userDto.getLogin());
        if (user.isPresent()) {
            if (isValidPassword(user.get(), userDto.getPassword())) {
                return new UserDto(user.get().getId(),
                        user.get().getName(),
                        user.get().getLogin(),
                        user.get().getPassword());
            } else {
                throw new RuntimeException("Password incorrect!");
            }
        } else return null;
    }

    /**
     * Method to check if login is blank for UsersLoginServlet.
     *
     * @param userDto user data.
     * @return Map with errors.
     */
    public Map<String, String> login_errors(UserDto userDto) {
        Map<String, String> messages = new HashMap<>();
        if (BlankLogin(userDto.getLogin())) {
            messages.put("login", "Login should not be blank");
        }
        Optional<User> user = userDao.getByLogin(userDto.getLogin());
        if (!user.isPresent()) {
            messages.put("loginVal", "Login is not valid");
        }
        return messages;
    }

    /**
     * Method validates password.
     *
     * @param user entity.
     * @param password raw entered password.
     * @return True if password validate.
     */
    private boolean isValidPassword(User user, String password) {
        String salt = user.getSalt();
        String passHash = user.getPassword();
        String userPass = generateHashPassword(password, salt);
        return userPass.equals(passHash);
    }
}
