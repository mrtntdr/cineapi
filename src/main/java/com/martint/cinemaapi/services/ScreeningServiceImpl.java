package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.mapper.AuditoriumMapper;
import com.martint.cinemaapi.api.v1.mapper.MovieMapper;
import com.martint.cinemaapi.api.v1.mapper.ScreeningMapper;
import com.martint.cinemaapi.api.v1.model.ScreeningDTO;
import com.martint.cinemaapi.domain.Screening;
import com.martint.cinemaapi.repositories.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    private final ScreeningRepository screeningRepository;
    private final ScreeningMapper screeningMapper;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository, ScreeningMapper screeningMapper) {
        this.screeningRepository = screeningRepository;
        this.screeningMapper = screeningMapper;
    }

    @Override
    public List<ScreeningDTO> getAllScreenings() {
        return screeningRepository.findAllByOrderByDateAsc()
                .stream()
                .map(screeningMapper::screeningToScreeningDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ScreeningDTO getScreeningById(Long id) {
        return screeningMapper.screeningToScreeningDTO(screeningRepository.findById(id).get());
    }

    @Override
    public ScreeningDTO createScreening(ScreeningDTO screeningDTO) {
        return saveAndReturnDTO(screeningDTO);
    }

    @Override
    public ScreeningDTO saveScreeningByDTO(Long id, ScreeningDTO screeningDTO) {
        screeningDTO.setId(id);
        return saveAndReturnDTO(screeningDTO);
    }

    //TODO: Make Patch Screening function
    @Override
    public ScreeningDTO patchScreeningByDTO(Long id, ScreeningDTO screeningDTO) {
        return screeningRepository.findById(id).map(
                screening -> {
                    if (screeningDTO.getDate() != null) screening.setDate(screeningDTO.getDate());
                    if (screeningDTO.getTime() != null) screening.setTime(screeningDTO.getTime());
                    if (screeningDTO.getMovie() != null) screening.setMovie(
                            MovieMapper.INSTANCE.movieDTOToMovie(screeningDTO.getMovie()));
                    if (screeningDTO.getAuditorium() != null) screening.setAuditorium(
                            AuditoriumMapper.INSTANCE.auditoriumDTOToAuditorium(screeningDTO.getAuditorium()));

                    ScreeningDTO returnDto = screeningMapper.screeningToScreeningDTO(
                            screeningRepository.save(screening));
                    return returnDto;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteScreening(Long id) {
        screeningRepository.deleteById(id);
    }

    private ScreeningDTO saveAndReturnDTO(ScreeningDTO screeningDTO) {
        Screening screening = screeningMapper.screeningDTOToScreening(screeningDTO);
        Screening savedScreening = screeningRepository.save(screening);
        return screeningMapper.screeningToScreeningDTO(savedScreening);
    }
}
