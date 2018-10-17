package com.martint.cinemaapi.controllers;

import com.martint.cinemaapi.api.v1.model.AuditoriumDTO;
import com.martint.cinemaapi.api.v1.model.MovieDTO;
import com.martint.cinemaapi.domain.Auditorium;
import com.martint.cinemaapi.services.AuditoriumService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(AuditoriumController.BASE_URL)
public class AuditoriumController {
    public static final String BASE_URL = "/api/auditorium";

    private final AuditoriumService auditoriumService;

    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping
    public List<AuditoriumDTO> getAllAuditoriums() {
        return auditoriumService.getAllAuditoriums();
    }

    @GetMapping("{id}")
    public AuditoriumDTO getAuditorium(@PathVariable Long id) {
        return auditoriumService.getAuditoriumById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuditoriumDTO createAuditorium(@RequestBody AuditoriumDTO auditorium) {
        return auditoriumService.createAuditorium(auditorium);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuditoriumDTO saveAuditorium(@PathVariable Long id, @RequestBody AuditoriumDTO auditoriumDTO) {
        return auditoriumService.saveAuditorium(id, auditoriumDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuditorium(@PathVariable Long id) {
        auditoriumService.deleteAuditorium(id);
    }
}
