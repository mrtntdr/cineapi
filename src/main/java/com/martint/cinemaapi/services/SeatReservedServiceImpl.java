package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.mapper.ReservationMapper;
import com.martint.cinemaapi.api.v1.mapper.SeatReservedMapper;
import com.martint.cinemaapi.api.v1.model.SeatReservedDTO;
import com.martint.cinemaapi.domain.SeatReserved;
import com.martint.cinemaapi.repositories.SeatReservedRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatReservedServiceImpl implements SeatReservedService {
    private final SeatReservedRepository repository;
    private final SeatReservedMapper mapper;

    public SeatReservedServiceImpl(SeatReservedRepository repository, SeatReservedMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SeatReservedDTO createSeatReservation(SeatReservedDTO reservation) {
        return saveAndReturnDTO(reservation);
    }

    @Override
    public SeatReservedDTO updateReservation(Long id, SeatReservedDTO reservation) {
        reservation.setId(id);
        return saveAndReturnDTO(reservation);
    }

    @Override
    public SeatReservedDTO patchReservation(Long id, SeatReservedDTO reservation) {
        SeatReserved seat = repository.findById(id).get();
        return mapper.seatReservedToDTO(seat);
    }

    private SeatReservedDTO saveAndReturnDTO(SeatReservedDTO reserved) {
        SeatReserved seat = mapper.DTOToSeatReserved(reserved);
        SeatReserved saved = repository.save(seat);
        return mapper.seatReservedToDTO(saved);
    }
}
