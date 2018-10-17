package com.martint.cinemaapi.api.v1.model;

import lombok.Data;

@Data
public class AuditoriumDTO {
    private Long id;
    private String name;
    private Integer numberOfSeats;
}
