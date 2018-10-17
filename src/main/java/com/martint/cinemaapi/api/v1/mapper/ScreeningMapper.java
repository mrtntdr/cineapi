package com.martint.cinemaapi.api.v1.mapper;

import com.martint.cinemaapi.api.v1.model.ScreeningDTO;
import com.martint.cinemaapi.domain.Screening;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScreeningMapper {
    ScreeningMapper INSTANCE = Mappers.getMapper(ScreeningMapper.class);

    ScreeningDTO screeningToScreeningDTO(Screening screening);

    Screening screeningDTOToScreening(ScreeningDTO screeningDTO);
}
