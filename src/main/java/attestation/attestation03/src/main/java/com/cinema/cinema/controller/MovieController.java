package com.cinema.cinema.controller;

import com.cinema.cinema.dto.MovieDto;
import com.cinema.cinema.service.MovieService;
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
@RequestMapping("/rest/movies")
@Tag(name = "Фильмы", description = "Контроллер для работы с фильмами")
public class MovieController {

    private final MovieService movieService;

    @Operation(description = "Получение фильма по id")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDto> getMovie (@Parameter(name = "id", description = "ID фильма") @RequestParam(value = "id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(null); // Обработка ошибки
        }
        MovieDto movieDto = movieService.getMovieById(id);
        return ResponseEntity.ok(movieDto);
    }

    @Operation(description = "Получение списка фильмов")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovieDto>> listMovies() {
        List<MovieDto> movies = movieService.findAllMovies();
        return ResponseEntity.ok(movies);
    }
    @Operation(description = "Создание фильма")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto newMovieDto) {
        MovieDto savedMovieDto = movieService.save(newMovieDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedMovieDto);
    }

    @Operation(description = "Обновление данных фильма по id")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDto> update (@RequestBody MovieDto newInfoDto, @RequestParam Long id) {
        MovieDto updatedMovieDto = movieService.update(newInfoDto, id);
        return ResponseEntity.ok(updatedMovieDto);
    }

    @Operation(description = "Удаление фильма по id")
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        movieService.softDeleteMovie(id);
        return ResponseEntity.noContent().build();}


}
