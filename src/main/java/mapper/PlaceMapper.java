package mapper;

import dao.DaoCRUD;
import dto.PlaceDto;
import entity.Place;


public class PlaceMapper {



    public static PlaceDto getPlaceDto(Place place) {
        PlaceDto placeDto=new PlaceDto();

        placeDto.setId(place.getId());
        placeDto.setCountry(place.getCountry());
        placeDto.setTown(place.getTown());
        placeDto.setName(place.getName());

        return placeDto;
    }

    public static Place getPlaceEntity(PlaceDto placeDto) {
        Place place=new Place();
        place.setId(placeDto.getId());
        place.setCountry(placeDto.getCountry());
        place.setTown(placeDto.getTown());
        place.setName(placeDto.getName());

        return place;
    }
}
