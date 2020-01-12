package dto;

import lombok.Data;

@Data
public class PlaceWithPhotoDto {

    private String country;
    private String town;
    private String photo;
    private String description;
    private int rate;
    private String name;
}
