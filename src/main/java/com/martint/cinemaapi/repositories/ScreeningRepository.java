package com.martint.cinemaapi.repositories;

import com.martint.cinemaapi.domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    public List<Screening> findAllByOrderByDateAsc();
}
