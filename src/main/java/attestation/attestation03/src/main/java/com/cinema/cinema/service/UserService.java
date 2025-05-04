package com.cinema.cinema.service;

import com.cinema.cinema.dto.UserDto;
import com.cinema.cinema.exception.NotFoundException;
import com.cinema.cinema.mapper.UserMapper;
import com.cinema.cinema.model.User;
import com.cinema.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utils.ProjestErrors.USER_NOT_FOUND_ERROR;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getUserById (Long id) throws NotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(USER_NOT_FOUND_ERROR));
        return userMapper.userToDto(user);

    }

    public List<UserDto> findAllUsers (){
        List <User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    public UserDto save (UserDto newUserDto) {
        User newUser = userMapper.userToEntity(newUserDto);
        newUser.setCreatedWhen(LocalDate.now());
        newUser.setCreatedBy("server_usr");
        User savedUser = userRepository.save(newUser);
        return userMapper.userToDto(savedUser);
            }

    public UserDto update (UserDto newInfoDto, Long id) {
        User existingUser = userRepository.findById(id)
                        .orElseThrow(()->new NotFoundException(USER_NOT_FOUND_ERROR));
        existingUser.setName(newInfoDto.getUser_name());
        existingUser.setDescription(newInfoDto.getDescription());
        User updatedUser = userRepository.save(existingUser);
        return userMapper.userToDto(updatedUser);
    }
    public void softDeleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_ERROR));
        user.setDeleted(true); // флаг Soft Delete
        userRepository.save(user);
    }
}
