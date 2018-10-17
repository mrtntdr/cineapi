package com.martint.cinemaapi.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
    private List<Seat> seats;
    @Setter(AccessLevel.PRIVATE)
    private Integer numberOfSeats;

    public Auditorium() {
    }

    public Auditorium(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeats() {
        if (seats != null) return seats.size();
        else return null;
    }
}
