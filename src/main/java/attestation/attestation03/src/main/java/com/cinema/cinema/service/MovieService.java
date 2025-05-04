package com.cinema.cinema.service;

import com.cinema.cinema.dto.MovieDto;
import com.cinema.cinema.exception.NotFoundException;
import com.cinema.cinema.mapper.MovieMapper;
import com.cinema.cinema.model.Movie;
import com.cinema.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utils.ProjestErrors.MOVIE_NOT_FOUND_ERROR;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    @Autowired
    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieDto> findAllMovies() {
        List <Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movieMapper::MovietoDto)
                .collect(Collectors.toList());
    }

    public MovieDto getMovieById(Long id) throws NotFoundException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(MOVIE_NOT_FOUND_ERROR));
        return movieMapper.MovietoDto(movie);}

    public MovieDto save(MovieDto newMoviedto) {
        Movie newMovie = movieMapper.MovietoEntity(newMoviedto);
        newMovie.setCreatedWhen(LocalDate.now());
        newMovie.setCreatedBy("server_usr");
        Movie savedMovie = movieRepository.save(newMovie);
        return movieMapper.MovietoDto(savedMovie);
    }


    public MovieDto update (MovieDto newInfoDto, Long id) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(()->new NotFoundException(MOVIE_NOT_FOUND_ERROR));
        existingMovie.setTitle(newInfoDto.getTitle());
        existingMovie.setDescription(newInfoDto.getDescription());
        Movie updatedMovie = movieRepository.save(existingMovie);
        return movieMapper.MovietoDto(updatedMovie);}

    public void softDeleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MOVIE_NOT_FOUND_ERROR));
        movie.setDeleted(true);// флаг Soft Delete
        movieRepository.save(movie);
        }
    }

