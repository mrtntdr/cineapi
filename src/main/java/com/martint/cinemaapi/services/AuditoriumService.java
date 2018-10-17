package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.model.AuditoriumDTO;

import java.util.List;

public interface AuditoriumService {

    AuditoriumDTO getAuditoriumById(Long id);

    AuditoriumDTO createAuditorium(AuditoriumDTO auditorium);

    AuditoriumDTO saveAuditorium(Long id, AuditoriumDTO auditoriumDTO);

    void deleteAuditorium(Long id);

    List<AuditoriumDTO> getAllAuditoriums();
}
