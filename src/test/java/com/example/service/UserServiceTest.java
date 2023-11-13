package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.user.UserServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("""
            Verify the correct username was returned when user exists
            """)
    public void getUsername_WithValidUserId_ShouldReturnValidUsername() {
        //Given
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setEmail("Bob");
        user.setAge(23);

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        //When
        String actual = userService.getUserName(userId);

        //Then
        String expected = user.getEmail();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getUserName_WithNonExistingUserId_ShouldThrowException() {
        //Given
        Long userId = 100L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        //When
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> userService.getUserName(userId)
        );
        userRepository.findAll();

        //Then
        String expected = "Can't find user by id: " + userId;
        String actual = exception.getMessage();
        assertEquals(expected, actual);

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).findAll();
        verifyNoMoreInteractions(userRepository);
    }
}