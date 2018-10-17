package com.martint.cinemaapi.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screening")
    private Set<Reservation> reservations;

    public Screening() {
    }

    public Screening(Movie movie, Auditorium auditorium) {
        this.movie = movie;
        this.auditorium = auditorium;
    }
}
