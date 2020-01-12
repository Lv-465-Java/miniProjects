package mapper;

import dto.UserDto;
import entity.User;


public class UserMapper {

    public static UserDto getUserDto(User user) {
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setUserRole(user.getUserRole());

        return userDto;
    }

    public static User getUserEntity(UserDto userDto) {
        User user=new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setUserRole(userDto.getUserRole());

        return user;
    }
}
