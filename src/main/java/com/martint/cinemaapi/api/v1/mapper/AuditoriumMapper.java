package com.martint.cinemaapi.api.v1.mapper;

import com.martint.cinemaapi.api.v1.model.AuditoriumDTO;
import com.martint.cinemaapi.domain.Auditorium;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuditoriumMapper {
    AuditoriumMapper INSTANCE = Mappers.getMapper(AuditoriumMapper.class);

    AuditoriumDTO auditoriumToAuditoriumDTO(Auditorium auditoriumDTO);

    Auditorium auditoriumDTOToAuditorium(AuditoriumDTO AuditoriumDTO);
}
