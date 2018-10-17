package com.martint.cinemaapi.controllers;

import com.martint.cinemaapi.api.v1.model.MovieDTO;
import com.martint.cinemaapi.api.v1.model.MovieListDTO;
import com.martint.cinemaapi.domain.Movie;
import com.martint.cinemaapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(MovieController.BASE_URL)
public class MovieController {

    public static final String BASE_URL = "/api/movies";

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO getMovieById( @PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO createMovie( @RequestBody MovieDTO movieDTO) {
        return movieService.createMovie(movieDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        return movieService.saveMovieByDTO(id, movieDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO patchMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        return movieService.patchMovieByDTO(id, movieDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
