package com.martint.cinemaapi.api.v1.model;

import lombok.Data;

@Data
public class ReservationDTO {
    private Long id;
    private ScreeningDTO screening;
    private SeatReservedDTO seatReserved;
    private Boolean isReserved;
    private Boolean isPaid;
    private Boolean isActive;
}
