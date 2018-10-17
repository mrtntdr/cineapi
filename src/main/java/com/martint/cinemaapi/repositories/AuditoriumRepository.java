package com.martint.cinemaapi.repositories;

import com.martint.cinemaapi.domain.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}
