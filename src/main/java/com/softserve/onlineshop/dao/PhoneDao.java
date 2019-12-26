package com.softserve.onlineshop.dao;

import com.softserve.onlineshop.entity.Model;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.entity.Producer;

import java.util.Optional;

public interface PhoneDao extends Crud {
    void addPhone(Phone Phone);
    void deletePhone(Phone phone);
    Optional<Phone> findByModel(Model model);
    Optional<Phone> findByProducer(Producer producer);

}
