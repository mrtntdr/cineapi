package com.martint.cinemaapi.services;

import com.martint.cinemaapi.api.v1.mapper.SeatMapper;
import com.martint.cinemaapi.api.v1.model.SeatDTO;
import com.martint.cinemaapi.api.v1.model.SeatListDTO;
import com.martint.cinemaapi.domain.Seat;
import com.martint.cinemaapi.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;

    public SeatServiceImpl(SeatRepository seatRepository, SeatMapper seatMapper) {
        this.seatRepository = seatRepository;
        this.seatMapper = seatMapper;
    }

    @Override
    public List<SeatDTO> getAllSeats() {
        return seatRepository.findAll()
                .stream()
                .map(seatMapper::seatToSeatDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeatDTO getSeatById(Long id) {
        return seatMapper.seatToSeatDTO(seatRepository.findById(id).get());
    }

    @Override
    public SeatDTO createSeat(SeatDTO seatDTO) {
        return saveAndReturnDTO(seatDTO);
    }

    @Override
    public SeatListDTO createManySeat(SeatListDTO seatListDTO) {
        return new SeatListDTO(saveAndReturnManyDTO(seatListDTO));
    }

    @Override
    public SeatDTO saveSeatByDTO(Long id, SeatDTO seatDTO) {
        seatDTO.setId(id);
        return saveAndReturnDTO(seatDTO);
    }

    //TODO: Make Seat Patch
    @Override
    public SeatDTO patchSeatByDTO(Long id, SeatDTO seatDTO) {
        return null;
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    private SeatDTO saveAndReturnDTO(SeatDTO seatDTO) {
        Seat seat = seatMapper.seatDTOToSeat(seatDTO);
        Seat savedSeat = seatRepository.save(seat);
        return seatMapper.seatToSeatDTO(savedSeat);
    }


    private List<SeatDTO> saveAndReturnManyDTO(SeatListDTO seatListDTO) {
        List<Seat> seatsToDb = seatListDTO.getSeatListDTO().stream()
                .map(seatMapper::seatDTOToSeat)
                .collect(Collectors.toList());
        List<Seat> savedSeats = seatRepository.saveAll(seatsToDb);
        return savedSeats.stream()
                .map(seatMapper::seatToSeatDTO)
                .collect(Collectors.toList());
    }
}