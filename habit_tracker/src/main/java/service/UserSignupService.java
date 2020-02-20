package service;

import dto.UserDto;
import java.util.Map;

public interface UserSignupService {

    Map<String, String> create_user(UserDto userDto);
    UserDto isValid(UserDto userDto);
    Map<String, String> login_errors(UserDto userDto) ;
    Map<String,String> update(UserDto userDto);
}
