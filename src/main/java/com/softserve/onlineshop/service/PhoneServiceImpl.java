package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dao.impl.PhoneDaoImpl;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.exception.NotDeletedException;
import com.softserve.onlineshop.exception.NotInsertedException;

import java.util.List;
import java.util.Optional;

public class PhoneServiceImpl implements PhoneService {

    private PhoneDaoImpl phoneDao;

    public PhoneServiceImpl() {
        phoneDao = new PhoneDaoImpl();
    }

    @Override
    public boolean insert(PhoneDto phoneDto) {
        if (phoneDao.getById(phoneDto.getId()).isPresent()) {
            throw new NotInsertedException();
        } else {
            Phone phone = new Phone(phoneDto.getYear(), phoneDto.getPrice(),
                    phoneDto.getPhoto(), phoneDto.getColor(), phoneDto.getScreenDiagonal(),
                    phoneDto.getInternalMemory(), phoneDto.getModelId());
            phoneDao.insert(phone);
            return true;
        }
    }

    @Override
    public Optional<Phone> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Phone> getByFieldName(String fieldName, String fieldValue) {
        return null;
    }

    @Override
    public List<Phone> getAll() {
        return null;
    }

    @Override
    public boolean updateById(String... args) {
        return false;
    }

    @Override
    public boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (phoneDao.getById(id).isPresent()) {
            phoneDao.deleteById(id);
            return true;
        } else {
            throw new NotDeletedException();
        }
    }

    @Override
    public boolean delete(PhoneDto phoneDto) {
        return false;
    }
}
