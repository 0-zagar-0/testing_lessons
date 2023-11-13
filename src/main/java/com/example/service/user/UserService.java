package com.example.service.user;

import com.example.dto.user.UserRequestDto;
import com.example.dto.user.UserResponseDto;

public interface UserService {
    String getUserName(Long userId);

    UserResponseDto register(UserRequestDto request);
}
