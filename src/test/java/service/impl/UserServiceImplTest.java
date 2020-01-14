package service.impl;

import dao.DaoCRUD;
import dao.impl.UserDaoImpl;
import dto.CommentDto;
import dto.UserDto;
import entity.Comment;
import entity.Role;
import entity.User;
import mapper.CommentMapper;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import service.CommentService;
import service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private DaoCRUD<User> daoCRUD;

    //@InjectMocks
    UserService userService;

    @BeforeEach
    void init() {
        initMocks(this);
        userService=new UserServiceImpl();
       // daoCRUD=new UserDaoImpl();
    }

    @Test
    public void getAllUsersTest() {
        List<UserDto> testList = new ArrayList<>(Arrays
                .asList(new UserDto(1L,"first", "last", "username", "email",Role.USER),
                        new UserDto(2L,"first", "last", "username", "email", Role.USER),
                        new UserDto(3L,"first", "last", "username", "email", Role.USER),
                        new UserDto(4L,"first", "last", "username", "email", Role.USER)
                ));


        when(daoCRUD.getAll()).thenReturn(testList.stream().map(UserMapper::getUserEntity).collect(Collectors.toList()));
        List<UserDto> list = userService.getAll();
        assertEquals(4, list.size());
        verify(daoCRUD, times(1)).getAll();
    }

    @Test
    public void getUserByIdTest() {
        when(daoCRUD.getById(1L)).thenReturn(Optional.of(new User(1L, "first", "last", "username", "email", "password", Role.USER)));

        UserDto userDto = userService.getById(1L);

        assertEquals("first", userDto.getFirstName());
        assertEquals("last", userDto.getLastName());
        assertEquals("username", userDto.getUsername());
        assertEquals("email", userDto.getEmail());
        assertEquals(Role.USER, userDto.getUserRole());
    }

    @Test
    public void createUserTest()
    {
        User user=new User( "first", "last", "username", "email", "password");

        userService.insert(user);

        verify(daoCRUD, times(1)).insert(user);
    }
}
