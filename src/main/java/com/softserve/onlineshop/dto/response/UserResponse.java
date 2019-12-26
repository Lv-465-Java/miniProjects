package com.softserve.onlineshop.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String nickname;
    private String password;
    private String email;
    private String phone;
}
