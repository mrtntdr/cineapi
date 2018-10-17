package com.martint.cinemaapi.controllers;

import com.martint.cinemaapi.api.v1.model.ScreeningDTO;
import com.martint.cinemaapi.services.ScreeningService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ScreeningController.BASE_URL)
public class ScreeningController {
    public static final String BASE_URL = "/api/screening";
    private final ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ScreeningDTO> getAllScreenings() {
        return screeningService.getAllScreenings();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScreeningDTO getScreeningById(@PathVariable Long id) {
        return screeningService.getScreeningById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScreeningDTO createScreening(@RequestBody ScreeningDTO screeningDTO) {
        return screeningService.createScreening(screeningDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScreeningDTO updateScreening(@PathVariable Long id, @RequestBody ScreeningDTO screeningDTO) {
        return screeningService.saveScreeningByDTO(id, screeningDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScreeningDTO patchScreening(@PathVariable Long id, @RequestBody ScreeningDTO screeningDTO) {
        return screeningService.patchScreeningByDTO(id, screeningDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
    }
}
