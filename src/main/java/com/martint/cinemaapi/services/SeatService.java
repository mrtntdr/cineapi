package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.model.SeatDTO;
import com.martint.cinemaapi.api.v1.model.SeatListDTO;

import java.util.List;

public interface SeatService {
    List<SeatDTO> getAllSeats();

    SeatDTO getSeatById(Long id);

    SeatDTO createSeat(SeatDTO seatDTO);

    SeatListDTO createManySeat(SeatListDTO seatListDTO);

    SeatDTO saveSeatByDTO(Long id, SeatDTO seatDTO);

    SeatDTO patchSeatByDTO(Long id, SeatDTO seatDTO);

    void deleteSeat(Long id);
}
