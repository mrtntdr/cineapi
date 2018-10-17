package com.martint.cinemaapi.controllers;

import com.martint.cinemaapi.api.v1.model.ReservationDTO;
import com.martint.cinemaapi.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ReservationController.BASE_URL)
public class ReservationController {
    public static final String BASE_URL = "/api/reservation";
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationDTO getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDTO createReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationDTO updateReservation(@PathVariable Long id,
                                            @RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(id, reservationDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationDTO patchReservation(@PathVariable Long id,
                                           @RequestBody ReservationDTO reservationDTO) {
        return reservationService.patchReservation(id, reservationDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
