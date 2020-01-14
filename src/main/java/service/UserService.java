package service;

import dto.UserDto;
import dto.UserLoginDto;
import entity.Role;
import entity.User;
import exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public interface UserService {

    UserDto getById(Long id);

    UserDto getByField(String text);

    List<UserDto> getAll();

    List<UserDto> getAllLimit();


    boolean insert(User user);

    boolean updateByEntity(User user);

    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

    boolean delete(User user);

    boolean isRoleAdmin(User user);

    boolean isUsernameUnique(String username);
}
