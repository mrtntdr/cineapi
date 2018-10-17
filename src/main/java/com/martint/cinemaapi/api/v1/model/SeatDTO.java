package com.martint.cinemaapi.api.v1.model;

import com.martint.cinemaapi.domain.Auditorium;
import lombok.Data;

@Data
public class SeatDTO {
    private Long id;
    private Integer row;
    private Integer number;
    private Auditorium auditorium;
}
