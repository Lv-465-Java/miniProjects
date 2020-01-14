package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.dao.impl.ModelDaoImpl;
import com.softserve.onlineshop.dao.mapper.ModelRowMapper;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.entity.Phone;

public class PhoneDtoMapper {
    public PhoneDto mapToDto(Phone phone) {
       PhoneDto phoneDto = new PhoneDto();
       phoneDto.setId(phone.getId());
       phoneDto.setYear(phone.getYear());
       phoneDto.setPrice(phone.getPrice());
       phoneDto.setPhoto(phone.getPhoto());
       phoneDto.setColor(phone.getColor());
       phoneDto.setScreenDiagonal(phone.getScreenDiagonal());
       phoneDto.setInternalMemory(phone.getInternalMemory());
       phoneDto.setModelId(phone.getModelId());
       return phoneDto;
    }
}
