package com.softserve.onlineshop.service.impl;

import com.softserve.onlineshop.dao.impl.PhoneDaoImpl;
import com.softserve.onlineshop.dao.mapper.PhoneRowMapper;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.dto.mapper.PhoneDtoMapper;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.exception.NotFoundException;
import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.softserve.onlineshop.constant.Parameters.IMG_PATH;


public class PhoneServiceImpl implements PhoneService {

    private PhoneDaoImpl phoneDao;
    private ModelService modelService;

    public PhoneServiceImpl() {
        phoneDao = new PhoneDaoImpl();
        modelService = new ModelServiceImpl();
    }

    @Override
    public boolean save(PhoneDto phoneDto) {
        return phoneDao.insert(getPhone(null, phoneDto));
    }

    @Override
    public boolean updateById(PhoneDto phoneDto, Long id) {
        return phoneDao.updateById(getPhone(getById(id), phoneDto));
    }

    private Phone getPhone(Phone phone, PhoneDto phoneDto) {
        if (phone == null) {
            phone = new Phone();
        }
        phone.setYear(phoneDto.getYear());
        phone.setPrice(phoneDto.getPrice());
        phone.setPhoto(phoneDto.getPhoto());
        phone.setColor(phoneDto.getColor());
        phone.setScreenDiagonal(phoneDto.getScreenDiagonal());
        phone.setInternalMemory(phoneDto.getInternalMemory());
        phone.setModelId(modelService.getById(phoneDto.getModelId()).getId());
        return phone;
    }

    @Override
    public String savePhoto(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart("photo");
        String fileName = UUID.randomUUID().toString() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        InputStream fileStream = filePart.getInputStream();
        byte[] bytes = new byte[fileStream.available()];
        fileStream.read(bytes);
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(
                        new File(IMG_PATH + fileName)));
        bos.write(bytes);
        bos.close();
        return fileName;
    }

    @Override
    public Phone getById(Long id) {
        return phoneDao.getById(new PhoneRowMapper(), id)
                .orElseThrow(() -> new NotFoundException("Producer with id:" + id + " not found"));
    }

    @Override
    public PhoneDto getByIdDto(Long id) {
        return new PhoneDtoMapper().mapToDto(getById(id));
    }

    @Override
    public List<PhoneDto> getAll() {
        List<PhoneDto> phones = phoneDao.getAll(new PhoneRowMapper()).stream()
                .map(new PhoneDtoMapper()::mapToDto).collect(Collectors.toList());
        if (phones.isEmpty()) {
            throw new NotFoundException("Phones not found");
        }
        return phones;
    }

    @Override
    public boolean deleteById(Long id) {
        return phoneDao.deleteById(getById(id).getId());
    }
}
