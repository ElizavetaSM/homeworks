package com.cinema.cinema.mapper;

import com.cinema.cinema.dto.MovieDto;
import com.cinema.cinema.model.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDto MovietoDto(Movie movie);
    Movie MovietoEntity(MovieDto movieDto);
}
