
package service.impl;

import dao.DaoCRUD;
import dao.impl.PlaceDaoImpl;
import dto.PlaceDto;
import entity.Place;
import exception.NotFoundException;
import mapper.PlaceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class PlaceServiceImplTest {

    @Mock
    DaoCRUD<Place> daoCRUD;

    @Mock
    PlaceDaoImpl placeDao;

    @InjectMocks
    PlaceServiceImpl placeServiceImpl;

    List<PlaceDto> testPlaceDtoList = new ArrayList<>(Arrays
            .asList(new PlaceDto(1L, "country1", "town1", "name1"),
                    new PlaceDto(2L, "country2", "town2", "name2"),
                    new PlaceDto(3L, "country3", "town3", "name3"),
                    new PlaceDto(4L, "country4", "town4", "name4")
            ));

    List<Place> testPlaceList = testPlaceDtoList.stream().map(PlaceMapper::getPlaceEntity).collect(Collectors.toList());

    List<Place> emptyPlaceList = new ArrayList<>();

    Place testPlace = new Place(1L,
            "country1",
            "town1",
            "name1",
            "desc1",
            "photo1");

    PlaceDto testPlaceDto = PlaceMapper.getPlaceDto(testPlace);



    @Test
    public void getByIdTest() {

        when(daoCRUD.getById(1L)).thenReturn(Optional.of(testPlace));

        PlaceDto resultPlaceDto = placeServiceImpl.getById(1L);

        assertEquals(testPlaceDto, resultPlaceDto);

        verify(daoCRUD, times(1)).getById(anyLong());
    }

    @Test(expected = NotFoundException.class)
    public void getByIdExceptionTest() {

        when(daoCRUD.getById(anyLong())).thenReturn(Optional.empty());

        placeServiceImpl.getById(anyLong());
    }

    @Test
    public void getByFieldTest() {

        when(daoCRUD.getByField("country1")).thenReturn(Optional.of(testPlace));

        PlaceDto resultPlaceDto = placeServiceImpl.getByField("country1");

        assertEquals(testPlaceDto, resultPlaceDto);

        verify(daoCRUD, times(1)).getByField(anyString());
    }

    @Test(expected = NotFoundException.class)
    public void getByFieldExceptionTest() {

        when(daoCRUD.getByField(anyString())).thenReturn(Optional.empty());

        placeServiceImpl.getByField(anyString());
    }

    @Test
    public void getAllPlacesTest() {

        when(daoCRUD.getAll()).thenReturn(testPlaceList);

        List<PlaceDto> resultList = placeServiceImpl.getAll();

        assertEquals(testPlaceDtoList, resultList);

        verify(daoCRUD, times(1)).getAll();
    }

    @Test(expected = NotFoundException.class)
    public void getAllPlacesExceptionTest() {

        when(daoCRUD.getAll()).thenReturn(emptyPlaceList);

        placeServiceImpl.getAll();
    }

    @Test
    public void getAllLimitTest() {

        when(daoCRUD.getAllLimit()).thenReturn(testPlaceList);

        List<PlaceDto> resultList = placeServiceImpl.getAllLimit();

        assertEquals(testPlaceDtoList, resultList);

        verify(daoCRUD, times(1)).getAllLimit();
    }

    @Test(expected = NotFoundException.class)
    public void getAllLimitExceptionTest() {

        when(daoCRUD.getAllLimit()).thenReturn(emptyPlaceList);

        placeServiceImpl.getAllLimit();
    }

    @Test
    public void getByTemplateTest() {

        when(placeDao.getByTemplate(anyString())).thenReturn(testPlaceList);

        List<PlaceDto> resultList = placeServiceImpl.getByTemplate(anyString());

        assertTrue(1 < resultList.size());

        verify(placeDao, times(1)).getByTemplate(anyString());
    }

    @Test(expected = NotFoundException.class)
    public void getByTemplateExceptionTest() {

        when(placeDao.getByTemplate(anyString())).thenReturn(emptyPlaceList);

        placeServiceImpl.getByTemplate(anyString());
    }

    @Test
    public void insertTest() {

        when(daoCRUD.insert(testPlace)).thenReturn(true);

        boolean result = placeServiceImpl.insert(testPlace);

        assertTrue(result);

        verify(daoCRUD, times(1)).insert(testPlace);
    }

    @Test(expected = NotFoundException.class)
    public void insertExceptionTest() {

        when(daoCRUD.insert(testPlace)).thenReturn(false);

        placeServiceImpl.insert(testPlace);
    }

    @Test
    public void updateByEntityTest() {

        when(daoCRUD.updateByEntity(testPlace)).thenReturn(true);

        boolean result = placeServiceImpl.updateByEntity(testPlace);

        assertTrue(result);

        verify(daoCRUD, times(1)).updateByEntity(testPlace);
    }

    @Test(expected = NotFoundException.class)
    public void updateByEntityExceptionTest() {

        when(daoCRUD.updateByEntity(testPlace)).thenReturn(false);

        placeServiceImpl.updateByEntity(testPlace);
    }

    @Test
    public void updateByFieldTest() {

        when(daoCRUD.updateByField(anyString(), anyString())).thenReturn(true);

        boolean result = placeServiceImpl.updateByField(anyString(), anyString());

        assertTrue(result);

        verify(daoCRUD, times(1)).updateByField(anyString(), anyString());
    }

    @Test(expected = NotFoundException.class)
    public void updateByFieldExceptionTest() {

        when(daoCRUD.updateByField(anyString(), anyString())).thenReturn(false);

        placeServiceImpl.updateByField(anyString(), anyString());
    }

    @Test
    public void deleteByIdTest() {

        when(daoCRUD.deleteById(anyLong())).thenReturn(true);

        boolean result = placeServiceImpl.deleteById(anyLong());

        assertTrue(result);

        verify(daoCRUD, times(1)).deleteById(anyLong());
    }

    @Test(expected = NotFoundException.class)
    public void deleteByIdExceptionTest() {

        when(daoCRUD.deleteById(anyLong())).thenReturn(false);

        placeServiceImpl.deleteById(anyLong());
    }

    @Test
    public void deleteTest() {

        when(daoCRUD.delete(testPlace)).thenReturn(true);

        boolean result = placeServiceImpl.delete(testPlace);

        assertTrue(result);

        verify(daoCRUD, times(1)).delete(testPlace);
    }

    @Test(expected = NotFoundException.class)
    public void deleteExceptionTest() {

        when(daoCRUD.delete(testPlace)).thenReturn(false);

        placeServiceImpl.delete(testPlace);
    }
}