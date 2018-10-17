package com.martint.cinemaapi.repositories;

import com.martint.cinemaapi.domain.SeatReserved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatReservedRepository extends JpaRepository<SeatReserved, Long> {
}
