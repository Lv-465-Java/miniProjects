package service;

import dto.UserDto;
import dto.UserLoginDto;
import entity.User;

import java.util.List;

public interface UserService {

    UserDto getById(Long id);

    UserDto getByField(String text);

    List<UserDto> getAll();

    List<UserDto> getAllLimit();


    boolean insert(User user);

    boolean updateByEntity(User user);

    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

//    boolean deleteByFieldName(String textCondition);

    boolean delete(User user);
}
