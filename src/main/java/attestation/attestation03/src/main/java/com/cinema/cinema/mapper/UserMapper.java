package com.cinema.cinema.mapper;

import com.cinema.cinema.dto.UserDto;
import com.cinema.cinema.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToDto(User user);
    User userToEntity(UserDto userDto);


}
