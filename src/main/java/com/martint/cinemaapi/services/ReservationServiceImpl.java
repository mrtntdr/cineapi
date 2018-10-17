package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.mapper.ReservationMapper;
import com.martint.cinemaapi.api.v1.model.ReservationDTO;
import com.martint.cinemaapi.domain.Reservation;
import com.martint.cinemaapi.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        return reservationMapper.reservationToReservationDTO(reservationRepository.findById(id).get());
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        return saveAndReturnDTO(reservationDTO);
    }

    @Override
    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        reservationDTO.setId(id);
        return saveAndReturnDTO(reservationDTO);
    }

    //TODO: Make patch reservation
    @Override
    public ReservationDTO patchReservation(Long id, ReservationDTO reservationDTO) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    private ReservationDTO saveAndReturnDTO(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.reservationDTOToReservation(reservationDTO);
        Reservation saved = reservationRepository.save(reservation);
        return reservationMapper.reservationToReservationDTO(saved);
    }
}
