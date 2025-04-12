package com.example.AOP.service.impl;

import com.example.AOP.entity.User;
import com.example.AOP.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp () {
        MockitoAnnotations.openMocks(this);
        }

    @Test
    public void testFindAll () {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Olga"));
        when(userRepository.findAll()).thenReturn(users);

        List<User> foundUsers = userService.findAll();

        assertEquals(1, foundUsers.size());
        assertEquals("Olga", foundUsers.get(0).getName());
    }
    @Test
    public void testDeleteById() {
        userService.deleteById(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}


