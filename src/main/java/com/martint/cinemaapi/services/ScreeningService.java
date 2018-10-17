package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.model.ScreeningDTO;

import java.util.List;

public interface ScreeningService {
    List<ScreeningDTO> getAllScreenings();

    ScreeningDTO getScreeningById(Long id);

    ScreeningDTO createScreening(ScreeningDTO screeningDTO);

    ScreeningDTO saveScreeningByDTO(Long id, ScreeningDTO screeningDTO);

    ScreeningDTO patchScreeningByDTO(Long id, ScreeningDTO screeningDTO);

    void deleteScreening(Long id);
}
