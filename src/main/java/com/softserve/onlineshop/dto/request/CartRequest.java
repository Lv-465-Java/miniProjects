package com.softserve.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {

    private Integer quantity;
    private Long userId;
    private Long phoneId;
}
