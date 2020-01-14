package com.auto.dto.mapper;

import com.auto.dto.CarDto;
import com.auto.model.Car;


public class CarDtoMapper extends Converter<CarDto, Car> {

    public CarDtoMapper() {
        super(carDto -> new Car(carDto.getId(),carDto.getBrand(),carDto.getModel(),carDto.getNumber()
                        ,carDto.getVinCode(),carDto.getYear()),
                car -> new CarDto(car.getId(),car.getBrand(),car.getModel(),car.getNumber()
                        ,car.getVinCode(),car.getYear()));
    }
}
