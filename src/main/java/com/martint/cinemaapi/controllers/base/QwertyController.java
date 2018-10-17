package com.martint.cinemaapi.controllers.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(QwertyController.BASE_URL)
public class QwertyController {
    public static final String BASE_URL = "/api/qwerty";
    /*
    private final QwertyService qwertyService;

    // Ctor

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public qwertyDTO getAllQwertys() {
        return qwertyService.getAllQwertys();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public qwertyDTO getAllAs(@PathVariable Long id) {
        return qwertyService.getQwertyById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QwertyDTO createQwerty(@RequestBody QwertyDTO qwertyDTO) {
        return qwertyService.createQwerty(qwertyDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public QwertyDTO updateQwerty(@PathVariable Long id, @RequestBody QwertyDTO qwertyDTO) {
        return qwertyService.saveQwertyByDTO(id, movieDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public QwertyDTO patchQwerty(@PathVariable Long id, @RequestBody QwertyDTO qwertyDTO) {
        return qwertyService.patchQwertyByDTO(id, qwertyDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteQwerty(@PathVariable Long id) {
        qwertyService.deleteQwerty(id);
    }*/
}
