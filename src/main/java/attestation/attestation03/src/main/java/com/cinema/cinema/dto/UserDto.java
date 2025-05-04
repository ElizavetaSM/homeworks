package com.cinema.cinema.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDto {
    private Long id;
    private String user_name;
    private String password;
    private String description;
}
