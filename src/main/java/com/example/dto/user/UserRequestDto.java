package com.example.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {
    private String email;
    private int age;
    private String password;
    private String repeatPassword;
}
