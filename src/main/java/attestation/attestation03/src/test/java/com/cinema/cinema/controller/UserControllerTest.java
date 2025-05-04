package com.cinema.cinema.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.cinema.cinema.dto.UserDto;
import com.cinema.cinema.exception.NotFoundException;
import com.cinema.cinema.mapper.UserMapper;
import com.cinema.cinema.model.User;
import com.cinema.cinema.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;


public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById() {
        Long user_Id = 1L;
        UserDto userDto = new UserDto();
        userDto.setId(user_Id);
        userDto.setUser_name("Anna");

        // Настройка мока
        when(userService.getUserById(user_Id)).thenReturn(userDto);

        // Вызов метода
        ResponseEntity<UserDto> response = userController.getUser(user_Id);

        // Проверка результата
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(response.getBody().getUser_name(), "Anna");
    }
    @Test
    public void testListUsers() {
        // Данные для теста
        UserDto user1 = new UserDto();
        user1.setId(1L);
        user1.setUser_name("Anna");

        UserDto user2 = new UserDto();
        user2.setId(2L);
        user2.setUser_name("Bob");

        List<UserDto> users = Arrays.asList(user1, user2);

        // Настройка поведения мока
        when(userService.findAllUsers()).thenReturn(users);

        // Вызов метода контроллера
        ResponseEntity<List<UserDto>> response = userController.listUsers();

        // Проверка результата
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(users, response.getBody());
    }

    @Test
    public void testSaveUser() {
        // Данные для теста
        UserDto newUserDto = new UserDto();
        newUserDto.setUser_name("Anna");
        newUserDto.setPassword("12345");
        newUserDto.setDescription("New user");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setName("Anna");
        savedUser.setPassword("12345");
        savedUser.setDescription("New user");

        UserDto savedUserDto = new UserDto();
        savedUserDto.setId(1L);
        savedUserDto.setUser_name("Anna");
        savedUserDto.setPassword("12345");
        savedUserDto.setDescription("New user");

        // Настройка мока
        when(userMapper.userToEntity(newUserDto)).thenReturn(savedUser);
        when(userService.save(newUserDto)).thenReturn(savedUserDto);

        // Вызов метода
        ResponseEntity<UserDto> response = userController.save(newUserDto);

        // Проверка результата
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedUserDto, response.getBody());
    }

    @Test
    public void testUpdateUser() {
    // Данные для теста
    Long user_Id = 1L;
    UserDto newInfoDto = new UserDto();
    newInfoDto.setUser_name("Anna Updated");
    newInfoDto.setDescription("Updated user");

    User existingUser = new User();
    existingUser.setId(user_Id);
    existingUser.setName("Anna");
    existingUser.setDescription("New user");

    User updatedUser = new User();
    updatedUser.setId(user_Id);
    updatedUser.setName("Anna Updated");
    updatedUser.setDescription("Updated user");

    UserDto updatedUserDto = new UserDto();
    updatedUserDto.setId(user_Id);
    updatedUserDto.setUser_name("Anna Updated");
    updatedUserDto.setDescription("Updated user");

    // Настройка мока
    when(userService.update(newInfoDto, user_Id)).thenReturn(updatedUserDto);

    // Вызов метода
    ResponseEntity<UserDto> response = userController.update(newInfoDto, user_Id);

    // Проверка результата
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(updatedUserDto, response.getBody());
}

    @Test
    public void testUpdateUser_NotFound() {
    // Данные для теста
    Long user_Id = 1L;
    UserDto newInfoDto = new UserDto();
    newInfoDto.setUser_name("Anna Updated");
    newInfoDto.setDescription("Updated user");

    // Настройка поведения мока, чтобы выбросить исключение
    when(userService.update(newInfoDto, user_Id)).thenThrow(new NotFoundException("Пользователь не найден"));

    // Вызов метода и проверка на исключение
    NotFoundException thrown = org.junit.jupiter.api.Assertions.assertThrows(NotFoundException.class, () -> {
        userController.update(newInfoDto, user_Id);
    });

    // Проверка текста исключения
    assertEquals("Пользователь не найден", thrown.getMessage());
}

    @Test
    public void testDeleteUser() {
        // Данные для теста
        Long user_Id = 1L;

        // Вызов метода
        ResponseEntity<Void> response = userController.delete(user_Id);

        // Проверка, что метод softDeleteUser был вызван
        verify(userService, times(1)).softDeleteUser(user_Id);

        // Проверка возврата статуса NO_CONTENT
        assertEquals(ResponseEntity.noContent().build(), response);
    }

    @Test
    public void testDeleteUser_NotFound() {
        // Данные для теста
        Long user_Id = 1L;

        // Настройка мока, чтобы выбросить исключение
        doThrow(new NotFoundException("Пользователь не найден"))
                .when(userService).softDeleteUser(user_Id);

        // Вызов метода и проверка на исключение
        NotFoundException thrown = org.junit.jupiter.api.Assertions.assertThrows(NotFoundException.class, () -> {
            userController.delete(user_Id);
        });

        // Проверка исключения
        assertEquals("Пользователь не найден", thrown.getMessage());
    }
}




