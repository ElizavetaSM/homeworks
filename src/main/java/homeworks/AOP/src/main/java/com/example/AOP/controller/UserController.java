package com.example.AOP.controller;

import com.example.AOP.aspect.Logs;
import com.example.AOP.entity.User;
import com.example.AOP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users0")
public class UserController {
@Autowired
    private UserService userService;
@Logs
@GetMapping
    public List<User> getAllUsers () {
    return userService.findAll();

}

    }

