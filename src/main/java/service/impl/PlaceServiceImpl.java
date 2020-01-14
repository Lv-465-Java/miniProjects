package service.impl;

import dao.DaoCRUD;
import dao.impl.PlaceDaoImpl;
import dto.PlaceDto;
import entity.Place;
import exception.Message;
import exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.PlaceMapper;
import service.PlaceService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService, Message {

    private final DaoCRUD<Place> daoCRUD;

    public PlaceServiceImpl() {
        daoCRUD= new PlaceDaoImpl();
    }

    @Override
    public PlaceDto getById(Long id) {
        Place place= daoCRUD.getById(id)
                .orElseThrow(()->new NotFoundException(String.format(PLACE_NOT_FOUND_EXCEPTION_MESSAGE,id)));

        return PlaceMapper.getPlaceDto(place);
    }

    @Override
    public PlaceDto getByField(String text) {
        Place place = daoCRUD.getByField(text)
                .orElseThrow(()-> new NotFoundException(String.format(PLACENAME_NOT_FOUND_EXCEPTION_MESSAGE,text)));

        return PlaceMapper.getPlaceDto(place);
    }

    @Override
    public List<PlaceDto> getAll() {
        List<Place> list = daoCRUD.getAll();

        List<PlaceDto>placeDtoList= list.stream()
                .map(PlaceMapper::getPlaceDto)
                .collect(Collectors.toList());
        if (placeDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_PLACE_LIST_EXCEPTION_MESSAGE);
        } return placeDtoList;
    }

    @Override
    public List<PlaceDto> getAllLimit() {
        List<Place> list=daoCRUD.getAllLimit();

        List<PlaceDto>placeDtoList= list.stream()
                .map(PlaceMapper::getPlaceDto)
                .collect(Collectors.toList());

        if (placeDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_PLACE_LIST_EXCEPTION_MESSAGE);
        } return placeDtoList;
    }

    @Override
    public List<PlaceDto> getByTemplate(String template) {
        PlaceDaoImpl placeDao=new PlaceDaoImpl();
        List<Place> list=placeDao.getByTemplate(template);

        List<PlaceDto>placeDtoList= list.stream()
                .map(PlaceMapper::getPlaceDto)
                .collect(Collectors.toList());

        if (placeDtoList.isEmpty()){
            throw new NotFoundException(EMPTY_PLACE_LIST_EXCEPTION_MESSAGE);
        } return placeDtoList;
    }

    @Override
    public boolean insert(Place place) {
        if (daoCRUD.insert(place)){
            return true;
        } else {
            throw new NotFoundException(CREATE_PLACE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(Place place) {
        if (daoCRUD.updateByEntity(place)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_PLACE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByField(String text, String textCondition) {
        if (daoCRUD.updateByField(text, textCondition)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_PLACE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(daoCRUD.deleteById(id)){
            return true;
        } else {
            throw new NotFoundException(DELETE_PLACE_EXCEPTION_MESSAGE);
        }
    }
//
//    @Override
//    public boolean deleteByFieldName(String textCondition) {
//        return daoCRUD.deleteByFieldName(textCondition);
//    }

    @Override
    public boolean delete(Place place) {
        if (daoCRUD.delete(place)){
            return true;
        } else {
            throw new NotFoundException(DELETE_PLACE_EXCEPTION_MESSAGE);
        }
    }
}
