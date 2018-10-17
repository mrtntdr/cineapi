package com.martint.cinemaapi.api.v1.model;

import lombok.Data;

@Data
public class SeatReservedDTO {
    private Long id;
    private SeatDTO seat;
    private ReservationDTO reservation;
}
