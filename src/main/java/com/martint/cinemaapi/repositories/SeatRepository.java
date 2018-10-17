package com.martint.cinemaapi.repositories;

import com.martint.cinemaapi.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
