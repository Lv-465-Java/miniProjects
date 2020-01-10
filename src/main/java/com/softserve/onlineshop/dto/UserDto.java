package com.softserve.onlineshop.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String nickname;
    private String password;
    private String email;
    private String phone;

    public UserDto(String nickname, String password, String email, String phone) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public UserDto(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
