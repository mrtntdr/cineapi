package com.martint.cinemaapi.api.v1.mapper;

import com.martint.cinemaapi.api.v1.model.MovieDTO;
import com.martint.cinemaapi.domain.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(source = "id", target = "id")
    MovieDTO movieToMovieDTO(Movie movie);

    Movie movieDTOToMovie(MovieDTO movieDTO);
}
