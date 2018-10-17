package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.model.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieById(Long id);

    MovieDTO createMovie(MovieDTO movieDTO);

    MovieDTO saveMovieByDTO(Long id, MovieDTO movieDTO);

    MovieDTO patchMovieByDTO(Long id, MovieDTO movieDTO);

    void deleteMovie(Long id);
}
