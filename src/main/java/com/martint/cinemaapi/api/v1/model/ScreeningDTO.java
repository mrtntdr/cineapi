package com.martint.cinemaapi.api.v1.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ScreeningDTO {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private MovieDTO movie;
    private AuditoriumDTO auditorium;

    //TODO: ADD RESERVATION
    //private Set<Reservation> reservations;

    //TODO: modify posting DTO to accept movie and auditorium Id's (long)

}
