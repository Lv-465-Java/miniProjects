package service.impl;

import dao.impl.UserDaoImpl;
import dto.UserDto;
import entity.Role;
import entity.User;
import exception.Message;
import exception.NotFoundException;
import mapper.UserMapper;
import service.UserService;

import java.util.List;
import java.util.stream.Collectors;


public class UserServiceImpl implements UserService, Message {

    private  UserDaoImpl userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public UserDto getById(Long id) {
        User user = userDao.getById(id)
                .orElseThrow(() -> new NotFoundException(String.format(USER_NOT_FOUND_EXCEPTION_MESSAGE, id)));
        return UserMapper.getUserDto(user);
    }

    @Override
    public UserDto getByField(String text) {

        User user = userDao.getByField(text)
                .orElseThrow(()-> new NotFoundException(String.format(USERNAME_NOT_FOUND_EXCEPTION_MESSAGE,text)));

        return UserMapper.getUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {

        List<User> list = userDao.getAll();

        List<UserDto>dtoList= list.stream()
                .map(UserMapper::getUserDto)
                .collect(Collectors.toList());

        if (dtoList.isEmpty()){
            throw new NotFoundException(EMPTY_USER_LIST_EXCEPTION_MESSAGE);
        } return dtoList;
    }

    @Override
    public List<UserDto> getAllLimit() {

        List<User> list = userDao.getAllLimit();

        List<UserDto>dtoList=  list.stream()
                .map(UserMapper::getUserDto)
                .collect(Collectors.toList());

        if (dtoList.isEmpty()){
            throw new NotFoundException(EMPTY_USER_LIST_EXCEPTION_MESSAGE);
        } return dtoList;
    }

    @Override
    public boolean insert(User user) {

        if(userDao.insert(user)){
            return true;
        } else {
            throw new NotFoundException(CREATE_USER_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(User user) {

        if(userDao.updateByEntity(user)){
            return true;
        } throw new NotFoundException(UPDATE_USER_EXCEPTION_MESSAGE);
    }

    @Override
    public boolean updateByField(String text, String textCondition) {

        if(userDao.updateByField(text, textCondition)){
            return true;
        } throw new NotFoundException(UPDATE_USER_EXCEPTION_MESSAGE);
    }

    @Override
    public boolean deleteById(Long id) {

        if(userDao.deleteById(id)){
            return true;
        } throw new NotFoundException(DELETE_USER_EXCEPTION_MESSAGE);
    }

    @Override
    public boolean delete(User user) {

        if(userDao.delete(user)){
            return true;
        } throw new NotFoundException(DELETE_USER_EXCEPTION_MESSAGE);
    }

    public boolean isRoleAdmin(User user){
        return user.getUserRole().equals(Role.ADMIN) & user.getPassword().equals("admin");
    }

    public boolean isUsernameUnique(String username){
        List<String> list= userDao.getAll().stream().map(User::getUsername).filter(u->(u.equals(username))).collect(Collectors.toList());
        if(list.isEmpty()){
            return true;
        } else {
            throw new NotFoundException(String.format(USERNAME_NOT_FOUND_EXCEPTION_MESSAGE,username));
        }
    }

}
