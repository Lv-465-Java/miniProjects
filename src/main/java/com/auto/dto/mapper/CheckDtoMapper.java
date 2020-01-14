package com.auto.dto.mapper;

import com.auto.dto.CheckDto;
import com.auto.model.Check;

public class CheckDtoMapper extends Converter<CheckDto, Check> {
    public CheckDtoMapper() {
        super(checkDto -> new Check(checkDto.getIdCar(), checkDto.getIdClient(), checkDto.getDate()),
                check -> new CheckDto(check.getIdCar(), check.getIdClient(), check.getDate()));

    }
}
