package com.martint.cinemaapi.api.v1.model;

import lombok.Data;

@Data
public class MovieDTO {
    private Long id;
    private String title;
    private String director;
    private String country;
    private String language;
    private String cast;
    private String description;
    private Integer duration;
}
