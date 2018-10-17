package com.martint.cinemaapi.api.v1.model;

import lombok.Data;

import java.util.List;

@Data
public class SeatListDTO {
    private List<SeatDTO> seatListDTO;

    public SeatListDTO() {
    }

    public SeatListDTO(List<SeatDTO> seatListDTO) {
        this.seatListDTO = seatListDTO;
    }
}
