package com.martint.cinemaapi.api.v1.model;

import lombok.Data;

import java.util.List;

@Data
public class MovieListDTO {
    Iterable<MovieDTO> movies;

    public MovieListDTO(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
