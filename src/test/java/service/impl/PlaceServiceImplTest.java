package service.impl;

import dao.DaoCRUD;
import dto.PlaceDto;
import dto.UserDto;
import entity.Place;
import entity.Role;
import entity.User;
import mapper.PlaceMapper;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import service.PlaceService;
import service.UserService;

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
public class PlaceServiceImplTest {

    @Mock
    private DaoCRUD<Place> daoCRUD;

    //@InjectMocks
    PlaceService placeService;

    @BeforeEach
    void init() {
        initMocks(this);
        placeService=new PlaceServiceImpl();
        // daoCRUD=new UserDaoImpl();
    }

    @Test
    public void getAllPlacesTest() {
        List<PlaceDto> testList = new ArrayList<>(Arrays
                .asList(new PlaceDto(1L, "country", "town", "name"),
                        new PlaceDto(2L, "country", "town", "name"),
                        new PlaceDto(3L, "country", "town", "name"),
                        new PlaceDto(4L, "country", "town", "name")
                ));


        when(daoCRUD.getAll()).thenReturn(testList.stream().map(PlaceMapper::getPlaceEntity).collect(Collectors.toList()));
        List<PlaceDto> list = placeService.getAll();
        assertEquals(4, list.size());
        verify(daoCRUD, times(1)).getAll();
    }

    @Test
    public void getPlaceByIdTest() {
        when(daoCRUD.getById(1L)).thenReturn(Optional.of(new Place(1L, "country", "town", "name", "desc", "photo")));

        PlaceDto placeDto = placeService.getById(1L);

        assertEquals("country", placeDto.getCountry());
        assertEquals("town", placeDto.getTown());
        assertEquals("name", placeDto.getName());
    }

    @Test
    public void createPlaceTest()
    {
        Place place=new Place( 1L, "country", "town", "name", "desc", "photo");

        placeService.insert(place);

        verify(daoCRUD, times(1)).insert(place);
    }
}
