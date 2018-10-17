package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.mapper.AuditoriumMapper;
import com.martint.cinemaapi.api.v1.model.AuditoriumDTO;
import com.martint.cinemaapi.domain.Auditorium;
import com.martint.cinemaapi.repositories.AuditoriumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    private final AuditoriumRepository auditoriumRepository;
    private final AuditoriumMapper auditoriumMapper;

    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository, AuditoriumMapper auditoriumMapper) {
        this.auditoriumRepository = auditoriumRepository;
        this.auditoriumMapper = auditoriumMapper;
    }

    @Override
    public AuditoriumDTO getAuditoriumById(Long id) {
        return auditoriumMapper.auditoriumToAuditoriumDTO(auditoriumRepository.findById(id).get());
    }

    @Override
    public AuditoriumDTO createAuditorium(AuditoriumDTO auditorium) {
        return saveAndReturnDTO(auditorium);
    }

    @Override
    public AuditoriumDTO saveAuditorium(Long id, AuditoriumDTO auditoriumDTO) {
        auditoriumDTO.setId(id);
        return saveAndReturnDTO(auditoriumDTO);
    }

    @Override
    public void deleteAuditorium(Long id) {
        auditoriumRepository.deleteById(id);
    }

    private AuditoriumDTO saveAndReturnDTO(AuditoriumDTO auditoriumDTO) {
        Auditorium auditorium = auditoriumMapper.auditoriumDTOToAuditorium(auditoriumDTO);
        Auditorium savedAuditorium = auditoriumRepository.save(auditorium);
        return auditoriumMapper.auditoriumToAuditoriumDTO(savedAuditorium);
    }

    @Override
    public List<AuditoriumDTO> getAllAuditoriums() {
        return auditoriumRepository.findAll()
                .stream().map(auditoriumMapper::auditoriumToAuditoriumDTO)
                .collect(Collectors.toList());
    }
}
