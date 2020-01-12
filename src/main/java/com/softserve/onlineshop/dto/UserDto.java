package com.softserve.onlineshop.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDto {
    private Long id;
    private String nickname;
    private String password;
    private String email;
    private String phone;
    private String role;

    public UserDto(Long id, String nickname, String password, String email, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

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
