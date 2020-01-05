package com.softserve.onlineshop.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String nickname;
    private String password;
    private String email;
    private String phone;
    private Long cartId;
}
