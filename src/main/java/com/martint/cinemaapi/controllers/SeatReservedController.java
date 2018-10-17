package com.martint.cinemaapi.controllers;

import com.martint.cinemaapi.api.v1.model.SeatReservedDTO;
import com.martint.cinemaapi.services.SeatReservedService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeatReservedController {
    private final SeatReservedService service;

    public SeatReservedController(SeatReservedService service) {
        this.service = service;
    }

    @PostMapping("/api/reserve/seat/")
    @ResponseStatus(HttpStatus.CREATED)
    public SeatReservedDTO createSeatReservation(@RequestBody SeatReservedDTO reservation) {
        return service.createSeatReservation(reservation);
    }

    @PutMapping("/api/reserve/seat/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeatReservedDTO updateReservation(@PathVariable Long id, @RequestBody SeatReservedDTO reservation) {
        return service.updateReservation(id, reservation);
    }

    @PatchMapping("/api/reserve/seat/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeatReservedDTO patchReservation(@PathVariable Long id, @RequestBody SeatReservedDTO reservation) {
        return service.patchReservation(id, reservation);
    }
}
