package com.martint.cinemaapi.controllers;

import com.martint.cinemaapi.api.v1.model.SeatDTO;
import com.martint.cinemaapi.api.v1.model.SeatListDTO;
import com.martint.cinemaapi.services.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SeatController.BASE_URL)
public class SeatController {

    public static final String BASE_URL = "/api/seat";

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SeatListDTO getAllSeats() {
        return new SeatListDTO(seatService.getAllSeats());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeatDTO getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeatDTO createSeat(@RequestBody SeatDTO seatDTO) {
        return seatService.createSeat(seatDTO);
    }

//    @PostMapping("/many")
//    @ResponseStatus(HttpStatus.CREATED)
//    public SeatListDTO createManySeats(@RequestBody SeatListDTO seatListDTO) {
//        return seatService.createManySeat(seatListDTO);
//    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeatDTO updateSeat(@PathVariable Long id, @RequestBody SeatDTO seatDTO) {
        return seatService.saveSeatByDTO(id, seatDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeatDTO patchSeat(@PathVariable Long id, @RequestBody SeatDTO seatDTO) {
        return seatService.patchSeatByDTO(id, seatDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
    }
}
