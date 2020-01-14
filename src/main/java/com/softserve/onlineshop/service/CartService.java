package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dto.CartDto;
import com.softserve.onlineshop.entity.Cart;

import java.util.List;

public interface CartService {

    boolean addToCart(CartDto cartDto);

    Cart getByPhoneId(Long phoneId);

    CartDto getByPhoneIdDto(Long phoneId);

    List<CartDto> getByUserId(Long userId);

//    CartDto getByUserIdDto(Long userId);

    boolean buyProduct(CartDto cartDto, Long phoneId);

    boolean deleteById(Long phoneId);
}
