package com.martint.cinemaapi.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer row;
    private Integer number;
    @ManyToOne
    private Auditorium auditorium;

    public Seat() {
    }

    public Seat(Integer row, Integer number, Auditorium auditorium) {
        this.row = row;
        this.number = number;
        this.auditorium = auditorium;
    }
}
