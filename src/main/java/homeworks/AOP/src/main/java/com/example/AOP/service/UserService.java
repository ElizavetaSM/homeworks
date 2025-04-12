package com.example.AOP.service;

import com.example.AOP.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll ();
    User save(User user);
    void deleteById(Long id);





}
