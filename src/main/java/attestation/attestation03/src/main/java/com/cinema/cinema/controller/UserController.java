package com.cinema.cinema.controller;

import com.cinema.cinema.dto.UserDto;
import com.cinema.cinema.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/users")
@Tag(name = "Пользователи", description = "Контроллер для работы с пользователями")
public class UserController {

    private final UserService userService;


    @Operation(description = "Получение пользователя по id")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser (@Parameter(name = "id", description = "ID пользователя") @RequestParam(value = "id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(null); // Обработка ошибки
        }
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @Operation(description = "Получение списка пользователей")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> listUsers() {
        List<UserDto> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }
    @Operation(description = "Создание пользователя")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> save(@RequestBody UserDto newUserDto) {
        UserDto savedUserDto = userService.save(newUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDto);
    }

    @Operation(description = "Обновление данных пользователя по id")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> update(
            @RequestBody UserDto newInfoDto, @RequestParam(value = "id") Long id) {
        UserDto updatedUserDto = userService.update(newInfoDto, id);
        return ResponseEntity.ok(updatedUserDto);
    }

    @Operation(description = "Удаление пользователя по id")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.softDeleteUser(id);
        return ResponseEntity.noContent().build();


}}
