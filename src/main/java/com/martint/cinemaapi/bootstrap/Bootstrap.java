package com.martint.cinemaapi.bootstrap;

import com.martint.cinemaapi.domain.*;
import com.martint.cinemaapi.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    /*
    This class is loading initial data to all classes for testing purpose
     */
    private AuditoriumRepository auditoriumRepository;
    private MovieRepository movieRepository;
    private ReservationRepository reservationRepository;
    private ScreeningRepository screeningRepository;
    private SeatRepository seatRepository;
    private SeatReservedRepository seatReservedRepository;

    public Bootstrap(AuditoriumRepository auditoriumRepository,
                     MovieRepository movieRepository, ReservationRepository reservationRepository,
                     ScreeningRepository screeningRepository, SeatRepository seatRepository,
                     SeatReservedRepository seatReservedRepository) {
        this.auditoriumRepository = auditoriumRepository;
        this.movieRepository = movieRepository;
        this.reservationRepository = reservationRepository;
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.seatReservedRepository = seatReservedRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Movie movie = makeMovies();
        Auditorium auditorium = makeAuditorium();
        Seat seat = makeSeats(auditorium);
        Screening screening = makeScreening(movie, auditorium);
        SeatReserved seatReserved = makeSeatReservations(seat, screening);
        Set<SeatReserved> seatReservedSet = new HashSet<>();
        seatReservedSet.add(seatReserved);
        makeReservations(screening, seatReservedSet);
        //log.info("Created movie: " );
    }

    private Movie makeMovies() {
        Movie movie = new Movie();
        movie.setTitle("Thor: Ragnarok");
        movie.setDirector("Taika Waititi");
        movie.setCountry("USA");
        movie.setLanguage("English");
        movie.setCast("Chris Hemsworth, Tom Hiddleston, Cate Blanchett");
        movie.setDescription("Imprisoned, the almighty Thor finds himself in a lethal gladiatorial contest against the" +
                "Hulk, his former ally. Thor must fight for survival and race against time to prevent the all-powerful" +
                "Hela from destroying his home and the Asgardian civilization.");
        movie.setDuration(130);
        movieRepository.save(movie);
        return movie;
    }

    private Auditorium makeAuditorium() {
        Auditorium auditorium = new Auditorium("Suur saal");
        auditoriumRepository.save(auditorium);
        return auditorium;
    }

    private Seat makeSeats(Auditorium auditorium) {
        Set<Seat> seats = new HashSet<>();
        Seat firstSeat = new Seat(1,1, auditorium);
        seats.add(firstSeat);
        seats.add(new Seat(2,1, auditorium));
        seats.add(new Seat(3,1, auditorium));
        seats.add(new Seat(1,2, auditorium));
        seats.add(new Seat(2,2, auditorium));
        seats.add(new Seat(3,2, auditorium));
        seats.add(new Seat(1,3, auditorium));
        seats.add(new Seat(2,3, auditorium));
        seats.add(new Seat(3,3, auditorium));
        seatRepository.saveAll(seats);
        return firstSeat;
    }

    private Screening makeScreening(Movie movie, Auditorium auditorium) {
        LocalDate screeningDate = LocalDate.now();
        LocalTime screeningTime = LocalTime.now();
        Screening screening = new Screening(movie, auditorium);
        screening.setDate(screeningDate);
        screening.setTime(screeningTime);
        screeningRepository.save(screening);
        return screening;
    }

    private SeatReserved makeSeatReservations(Seat seat, Screening screening) {
        SeatReserved seatReserved = new SeatReserved(seat, screening);
        seatReservedRepository.save(seatReserved);
        return seatReserved;
    }


    private void makeReservations(Screening screening, Set<SeatReserved> seatReserved) {
        Reservation reservation = new Reservation(screening,  seatReserved, true, false);
        reservationRepository.save(reservation);
    }

}
