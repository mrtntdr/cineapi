package com.martint.cinemaapi.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Screening screening;
    @OneToMany(mappedBy = "reservation")
    private Set<SeatReserved> seatsReserved;
    //TODO: Add User and roles
    private Boolean isReserved;
    private Boolean isPaid;
    private Boolean isActive;
    //private ReservationType reservationType;


    public Reservation() {
    }

    public Reservation(Screening screening, Set<SeatReserved> seatsReserved, Boolean isReserved, Boolean isPaid) {
        this.screening = screening;
        this.seatsReserved = seatsReserved;
        this.isReserved = isReserved;
        this.isPaid = isPaid;
    }
}
