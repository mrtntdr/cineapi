package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.model.SeatReservedDTO;

public interface SeatReservedService {
    SeatReservedDTO createSeatReservation(SeatReservedDTO reservation);

    SeatReservedDTO updateReservation(Long id, SeatReservedDTO reservation);

    SeatReservedDTO patchReservation(Long id, SeatReservedDTO reservation);
}
