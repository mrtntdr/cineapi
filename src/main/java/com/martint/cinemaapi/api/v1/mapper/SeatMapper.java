package com.martint.cinemaapi.api.v1.mapper;

import com.martint.cinemaapi.api.v1.model.SeatDTO;
import com.martint.cinemaapi.domain.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);


    SeatDTO seatToSeatDTO(Seat seat);
    Seat seatDTOToSeat(SeatDTO seatDTO);
}
