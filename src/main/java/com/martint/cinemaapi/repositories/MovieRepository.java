package com.martint.cinemaapi.repositories;

import com.martint.cinemaapi.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);

}
