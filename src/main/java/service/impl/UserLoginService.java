package service.impl;

import dto.UserDto;
import dto.UserLoginDto;
import exception.Message;
import exception.NotFoundException;
import service.UserService;

public class UserLoginService implements Message {

    private UserService userService;

    public UserLoginService() {
        userService=new UserServiceImpl();
    }

    public boolean isValid(UserLoginDto userLoginDto) {
        boolean status;
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();

        if (username == null || password == null ||
                username.length() == 0 || password.length() == 0) {
           status= false;
        } else {
            try {
                getUserDto(userLoginDto);
                status= true;
            } catch (NotFoundException e) {
                e.getMessage();
                status= false;
            }
        }
        return status;
    }

    public UserDto getUserDto(UserLoginDto userLoginDto){
        return userService.getByField(userLoginDto.getUsername());
    }

}
