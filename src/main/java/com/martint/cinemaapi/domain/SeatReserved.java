package com.martint.cinemaapi.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SeatReserved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Reservation reservation;
    @ManyToOne
    private Screening screening;

    public SeatReserved() {
    }

    public SeatReserved(Seat seat, Screening screening) {
        this.seat = seat;
        this.screening = screening;
    }
}
