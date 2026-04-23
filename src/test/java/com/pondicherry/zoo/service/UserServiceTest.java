package com.pondicherry.zoo.service;

import com.pondicherry.zoo.domain.Sex;
import com.pondicherry.zoo.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserServiceImpl userServiceImpl; // Assuming UserServiceImpl is the implementation of UserService

    @Test
    void shouldThrowExceptionWhenUserNameIsNull() {
        // Given
        String userName = null;
        String password = "password123";
        Sex sex = Sex.MALE; // Assuming Sex is an enum with MALE and FEMALE
        Date dob = new Date();
        String postcode = "12345";

        // When
        when(userService.register(userName, password, sex, dob, postcode)).thenThrow(new NullPointerException("Cannot invoke \"String.length()\" because \"userName\" is null"));

        // Then
        assertThrows(NullPointerException.class, () -> userServiceImpl.register(userName, password, sex, dob, postcode));
    }
}