package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.dto.CartDto;
import com.softserve.onlineshop.entity.Cart;

public class CartDtoMapper {
    public CartDto mapToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setPhoneId(cart.getPhoneId());
        cartDto.setUserId(cart.getUserId());
        cartDto.setDateOfBuying(cart.getDateOfBuying());
        return cartDto;
    }
}
