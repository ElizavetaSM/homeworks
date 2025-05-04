package com.cinema.cinema.controller;

import com.cinema.cinema.dto.MovieDto;
import com.cinema.cinema.exception.NotFoundException;
import com.cinema.cinema.mapper.MovieMapper;
import com.cinema.cinema.model.Movie;
import com.cinema.cinema.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class MovieControllerTest {

    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService movieService;

    @Mock
    private MovieMapper movieMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMovieById() {
        Long movie_Id = 1L;
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie_Id);
        movieDto.setTitle("The Witcher");

        // Настройка мока
        when(movieService.getMovieById(movie_Id)).thenReturn(movieDto);

        // Вызов метода
        ResponseEntity<MovieDto> response = movieController.getMovie(movie_Id);

        // Проверка результата
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(response.getBody().getTitle(), "The Witcher");
    }

    @Test
    public void testListMovies() {
        // Данные для теста
        MovieDto movie1 = new MovieDto();
        movie1.setId(1L);
        movie1.setTitle("The Witcher");

        MovieDto movie2 = new MovieDto();
        movie2.setId(1L);
        movie2.setTitle("Healer");

        List<MovieDto> movies = Arrays.asList(movie1, movie2);

        // Настройка поведения мока
        when(movieService.findAllMovies()).thenReturn(movies);

        // Вызов метода контроллера
        ResponseEntity<List<MovieDto>> response = movieController.listMovies();

        // Проверка результата
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(movies, response.getBody());
    }

    @Test
    public void testSaveMovie() {
        // Данные для теста
        MovieDto newMovieDto = new MovieDto();
        newMovieDto.setTitle("The Witcher");
        newMovieDto.setDescription("4th season");

        Movie savedMovie = new Movie();
        savedMovie.setId(1L);
        savedMovie.setTitle("The Witcher");
        savedMovie.setDescription("4th season");

        MovieDto savedMovieDto = new MovieDto();
        savedMovieDto.setId(1L);
        savedMovieDto.setTitle("The Witcher");
        savedMovieDto.setDescription("4th season");

        // Настройка мока
        when(movieMapper.MovietoEntity(newMovieDto)).thenReturn(savedMovie);
        when(movieService.save(newMovieDto)).thenReturn(savedMovieDto);

        // Вызов метода
        ResponseEntity<MovieDto> response = movieController.save(newMovieDto);

        // Проверка результата
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedMovieDto, response.getBody());
    }

    @Test
    public void testUpdateMovie() {
        // Данные для теста
        Long movie_Id = 1L;
        MovieDto newInfoDto = new MovieDto();
        newInfoDto.setTitle("The Witcher Season 4");
        newInfoDto.setDescription("Updated movie");

        Movie existingMovie = new Movie();
        existingMovie.setId(movie_Id);
        existingMovie.setTitle("The Witcher");
        existingMovie.setDescription("Updated movie");

        Movie updatedMovie = new Movie();
        updatedMovie.setId(movie_Id);
        updatedMovie.setTitle("The Witcher Season 4");
        updatedMovie.setDescription("Updated movie");

        MovieDto updatedMovieDto = new MovieDto();
        updatedMovieDto.setId(movie_Id);
        updatedMovieDto.setTitle("The Witcher Season 4");
        updatedMovieDto.setDescription("Updated movie");

        // Настройка мока
        when(movieService.update(newInfoDto, movie_Id)).thenReturn(updatedMovieDto);

        // Вызов метода
        ResponseEntity<MovieDto> response = movieController.update(newInfoDto, movie_Id);

        // Проверка результата
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedMovieDto, response.getBody());
    }

    @Test
    public void testUpdateMovie_NotFound() {
        // Данные для теста
        Long movie_Id = 1L;
        MovieDto newInfoDto = new MovieDto();
        newInfoDto.setTitle("The Witcher Season 4");
        newInfoDto.setDescription("Updated movie");

        // Настройка поведения мока, чтобы выбросить исключение
        when(movieService.update(newInfoDto, movie_Id)).thenThrow(new NotFoundException("Фильм не найден"));

        // Вызов метода и проверка на исключение
        NotFoundException thrown = org.junit.jupiter.api.Assertions.assertThrows(NotFoundException.class, () -> {
            movieController.update(newInfoDto, movie_Id);
        });

        // Проверка текста исключения
        assertEquals("Фильм не найден", thrown.getMessage());
    }

    @Test
    public void testDeleteMovie() {
        // Данные для теста
        Long movie_Id = 1L;

        // Вызов метода
        ResponseEntity<Void> response = movieController.delete(movie_Id);

        // Проверка, что метод softDeleteUser был вызван
        verify(movieService, times(1)).softDeleteMovie(movie_Id);

        // Проверка возврата статуса NO_CONTENT
        assertEquals(ResponseEntity.noContent().build(), response);
    }

    @Test
    public void testDeleteMovie_NotFound() {
        // Данные для теста
        Long movie_Id = 1L;

        // Настройка мока, чтобы выбросить исключение
        doThrow(new NotFoundException("Фильм не найден"))
                .when(movieService).softDeleteMovie(movie_Id);

        // Вызов метода и проверка на исключение
        NotFoundException thrown = org.junit.jupiter.api.Assertions.assertThrows(NotFoundException.class, () -> {
            movieController.delete(movie_Id);
        });

        // Проверка исключения
        assertEquals("Фильм не найден", thrown.getMessage());
    }}


