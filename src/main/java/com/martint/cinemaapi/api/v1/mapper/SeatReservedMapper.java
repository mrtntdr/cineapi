package com.martint.cinemaapi.api.v1.mapper;

import com.martint.cinemaapi.api.v1.model.SeatReservedDTO;
import com.martint.cinemaapi.domain.SeatReserved;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeatReservedMapper {
    SeatReservedMapper INSTANCE = Mappers.getMapper(SeatReservedMapper.class);

    SeatReservedDTO seatReservedToDTO(SeatReserved seatReserved);

    SeatReserved DTOToSeatReserved(SeatReservedDTO seatReservedDTO);
}
