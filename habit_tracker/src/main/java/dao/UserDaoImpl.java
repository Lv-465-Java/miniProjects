package dao;

import dao.mapper.UserRowMapper;
import dao.mapper.UserRowMapperWithSalt;
import dto.UserDto;
import entity.User;
import util.JdbcUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements Crud<User>{
    private final Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public int insert(User user) {
        try {
            String ADD_USER = "INSERT INTO USER( name, login, password, salt) VALUES( ? , ? , ? ,? );";
            return JdbcUtils.update(connection, ADD_USER, user.getName(), user.getLogin(),user.getPassword(),user.getSalt());
        }
        catch (Exception a){return 0;}
    }


    @Override
    public List<User> getAll() {
        try {
            String GET_ALL = "SELECT id,name,login,password FROM user";
            return JdbcUtils.query(connection, GET_ALL, new UserRowMapper());
        }
        catch (Exception a){return null;}
    }

    public Optional<User> getById(long id) {
        //try {
            String GET = "SELECT id,name,login,password FROM user WHERE id = ?";
            return JdbcUtils.queryForObject(connection, GET, new UserRowMapper(),id);
        //}
       // catch (Exception a){return null;}
    }

    public Optional<User> getByLoginAndPass(User user) {
        try {
            String GET_NAME = "SELECT id,name,login,password FROM user WHERE login = ? and password = ?";
            return JdbcUtils.queryForObject(connection, GET_NAME, new UserRowMapper(),user.getLogin(),user.getPassword());
        }
        catch (Exception a){return null;}
    }

    public Optional<User> getByLogin(String login) {
        try {
            String GET_NAME = "SELECT * FROM user WHERE login = ?";
            return JdbcUtils.queryForObject(connection, GET_NAME, new UserRowMapperWithSalt(),login);
        }
        catch (Exception a){return null;}
    }
    public Optional<User> getAllById(long id) {
        try {
            String GET_NAME = "SELECT * FROM user WHERE id = ?";
            return JdbcUtils.queryForObject(connection, GET_NAME, new UserRowMapperWithSalt(),id);
        }
        catch (Exception a){return null;}
    }


    @Override
    public int deleteById(long id) {
        try {
            String DELETE_USER = "DELETE FROM user WHERE id = ?";
            return JdbcUtils.update(connection, DELETE_USER, id);
        }
        catch (Exception a){return 0;}
    }

    @Override
    public int updateById(User user) {
        try {
            String UPDATE_PASS = "UPDATE user SET password = ? WHERE id = ?";
            return JdbcUtils.update(connection, UPDATE_PASS, user.getPassword(), user.getId());
        }
        catch (Exception a){return 0;}
    }

    public int updateAllById(User user) {
        try {
            String UPDATE_PASS = "UPDATE user SET name = ? , login = ? , password = ? WHERE id = ?";
            return JdbcUtils.update(connection, UPDATE_PASS, user.getName(),user.getLogin(),
                    user.getPassword(), user.getId());
        }
        catch (Exception a){return 0;}
    }

    public int updateNameById(long id, String name){
    try {
            String UPDATE_PASS = "UPDATE user SET name = ? WHERE id = ?";
           return JdbcUtils.update(connection, UPDATE_PASS, name, id);
         }
        catch (Exception a){return 0;}
    }
    public int updateLoginById(User user){
        try {
            String UPDATE_PASS = "UPDATE user SET login = ? WHERE id = ?";
            return JdbcUtils.update(connection, UPDATE_PASS, user.getLogin(), user.getId());
        }
        catch (Exception a){return 0;}
    }
}
