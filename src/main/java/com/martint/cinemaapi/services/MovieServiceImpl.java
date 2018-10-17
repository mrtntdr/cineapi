package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.mapper.MovieMapper;
import com.martint.cinemaapi.api.v1.model.MovieDTO;
import com.martint.cinemaapi.domain.Movie;
import com.martint.cinemaapi.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {


    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::movieToMovieDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        return movieMapper.movieToMovieDTO(movieRepository.findById(id).get());
    }

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        MovieDTO returnDto = saveAndReturnDTO(movieDTO);
        return returnDto;
    }

    @Override
    public MovieDTO saveMovieByDTO(Long id, MovieDTO movieDTO) {
        movieDTO.setId(id);
        MovieDTO returnDto = saveAndReturnDTO(movieDTO);
        return returnDto;
    }

    @Override
    public MovieDTO patchMovieByDTO(Long id, MovieDTO movieDTO) {
        return movieRepository.findById(id).map(
                movie -> {
                    if (movieDTO.getTitle() != null) movie.setTitle(movieDTO.getTitle());
                    if (movieDTO.getDirector() != null) movie.setDirector(movieDTO.getDirector());
                    if (movieDTO.getCountry() != null) movie.setCountry(movieDTO.getCountry());
                    if (movieDTO.getLanguage() != null) movie.setLanguage(movieDTO.getLanguage());
                    if (movieDTO.getCast() != null) movie.setCast(movieDTO.getCast());
                    if (movieDTO.getDescription() != null) movie.setDescription(movieDTO.getDescription());
                    if (movieDTO.getDuration() != null) movie.setDuration(movieDTO.getDuration());

                    MovieDTO returnDto = movieMapper.movieToMovieDTO(movieRepository.save(movie));
                    return returnDto;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    private MovieDTO saveAndReturnDTO(MovieDTO movieDTO) {
        Movie movie = movieMapper.movieDTOToMovie(movieDTO);
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.movieToMovieDTO(savedMovie);
    }
}
