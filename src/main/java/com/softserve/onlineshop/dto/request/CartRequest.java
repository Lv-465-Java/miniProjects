package com.softserve.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CartRequest {

    private LocalDateTime dateOfBuying;
    private Long userId;
    private Long phoneId;
}
