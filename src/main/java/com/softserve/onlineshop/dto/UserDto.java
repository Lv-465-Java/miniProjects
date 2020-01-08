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

    public UserDto(String nickname, String password, String email, String phone, Long cartId) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.cartId = cartId;
    }

    public UserDto(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
