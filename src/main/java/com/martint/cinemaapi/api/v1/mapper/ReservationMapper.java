package com.martint.cinemaapi.api.v1.mapper;

import com.martint.cinemaapi.api.v1.model.ReservationDTO;
import com.martint.cinemaapi.domain.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    ReservationDTO reservationToReservationDTO(Reservation reservation);

    Reservation reservationDTOToReservation(ReservationDTO reservationDTO);
}
