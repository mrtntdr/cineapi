package com.martint.cinemaapi.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private String country;
    private String language;
    @Lob
    private String cast;
    @Lob
    private String description;
    private Integer duration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private Set<Screening> screenings;
}
