package com.example.service.user;

import com.example.dto.user.UserRequestDto;
import com.example.dto.user.UserResponseDto;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String getUserName(Long userId) {
        return userRepository.findById(userId)
                .map(User::getEmail)
                .orElseThrow(
                () -> new RuntimeException("Can't find user by id: " + userId)
        );
    }

    @Override
    public UserResponseDto register(final UserRequestDto request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAge(request.getAge());
        return userMapper.toDto(userRepository.save(user));
    }
}
