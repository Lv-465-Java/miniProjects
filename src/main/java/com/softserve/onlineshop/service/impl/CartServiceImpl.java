package com.softserve.onlineshop.service.impl;

import com.softserve.onlineshop.dao.impl.CartDaoImpl;
import com.softserve.onlineshop.dao.mapper.CartRowMapper;
import com.softserve.onlineshop.dto.CartDto;
import com.softserve.onlineshop.dto.mapper.CartDtoMapper;
import com.softserve.onlineshop.entity.Cart;
import com.softserve.onlineshop.exception.NotFoundException;
import com.softserve.onlineshop.service.CartService;
import com.softserve.onlineshop.service.PhoneService;
import com.softserve.onlineshop.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CartServiceImpl implements CartService {
    private CartDaoImpl cartDao;
    private UserService userService;
    private PhoneService phoneService;

    public CartServiceImpl() {
        cartDao = new CartDaoImpl();
        userService = new UserServiceImpl();
        phoneService = new PhoneServiceImpl();
    }

    @Override
    public boolean addToCart(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setPhoneId(phoneService.getById(cartDto.getPhoneId()).getId());
        cart.setUserId(userService.getById(cartDto.getUserId()).getId());
        return cartDao.insert(cart);
    }

    @Override
    public Cart getByPhoneId(Long phoneId) {
        return cartDao.getById(new CartRowMapper(), phoneId)
                .orElseThrow(() -> new NotFoundException("Cart not found"));
    }


    @Override
    public CartDto getByPhoneIdDto(Long phoneId) {
        return new CartDtoMapper().mapToDto(getByPhoneId(phoneId));
    }

    @Override
    public List<CartDto> getByUserId(Long userId) {
        return cartDao.getByUserId(new CartRowMapper(), userId).stream()
                .map(new CartDtoMapper()::mapToDto).collect(Collectors.toList());
    }

    @Override
    public boolean buyProduct(CartDto cartDto, Long phoneId) {
        Cart cart = new Cart();
        cart.setPhoneId(phoneId);
        cart.setUserId(getByPhoneId(phoneId).getUserId());
        cart.setDateOfBuying(LocalDateTime.now());
        return cartDao.updateById(cart);
    }

    @Override
    public boolean deleteById(Long phoneId) {
        return cartDao.deleteById(getByPhoneId(phoneId).getPhoneId());
    }

}
