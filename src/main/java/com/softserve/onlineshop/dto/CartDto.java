package com.softserve.onlineshop.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CartDto {

    private Long phoneId;
    private Long userId;
    private LocalDateTime dateOfBuying;

    public CartDto(Long phoneId, Long userId) {
        this.phoneId = phoneId;
        this.userId = userId;
    }


}
