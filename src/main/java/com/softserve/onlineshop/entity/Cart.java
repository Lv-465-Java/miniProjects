package com.softserve.onlineshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {

    private Long id;
    private LocalDateTime dateOfBuying;
    private List<Phone> phones;
    private Long userId;
}
