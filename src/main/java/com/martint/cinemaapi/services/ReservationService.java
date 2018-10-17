package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.model.ReservationDTO;

public interface ReservationService {
    ReservationDTO getReservationById(Long id);

    ReservationDTO createReservation(ReservationDTO reservationDTO);

    ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO);

    ReservationDTO patchReservation(Long id, ReservationDTO reservationDTO);

    void deleteReservation(Long id);
}
