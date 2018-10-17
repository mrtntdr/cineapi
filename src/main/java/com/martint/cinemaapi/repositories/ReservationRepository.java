package com.martint.cinemaapi.repositories;

import com.martint.cinemaapi.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
