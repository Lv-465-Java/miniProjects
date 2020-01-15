package com.softserve.onlineshop.service;


import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.entity.Phone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


public interface PhoneService {

    boolean save(PhoneDto phoneDto);

    Phone getById(Long id);

    PhoneDto getByIdDto(Long id);

    List<PhoneDto> getAll();

    String savePhoto(HttpServletRequest request) throws IOException, ServletException;

    boolean updateById(PhoneDto phoneDto, Long id);

    boolean deleteById(Long id);

}
