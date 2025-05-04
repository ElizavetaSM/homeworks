package com.cinema.cinema.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private String description;
}
