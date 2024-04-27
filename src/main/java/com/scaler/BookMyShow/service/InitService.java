package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.dto.CityResponseDTO;
import com.scaler.BookMyShow.model.*;
import com.scaler.BookMyShow.model.constant.SeatStatus;
import com.scaler.BookMyShow.model.constant.SeatType;
import com.scaler.BookMyShow.model.constant.ShowSeatStatus;
import com.scaler.BookMyShow.repository.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class InitService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void initialize(){

        List<String> cities = List.of("Kochi", "CHRY", "TVLA", "Kottayam");
        /*City Delhi = new City("Delhi");
        City Mumbai = new City("Mumbai");
        City Chennai = new City("Chennai");
        City Bengaluru = new City("Bengaluru");

        cityRepository.save(Delhi);
        cityRepository.save(Mumbai);
        cityRepository.save(Chennai);
        cityRepository.save(Bengaluru);*/
        for(String city : cities){
            City c = new City(city);
            cityRepository.save(c);
        }

        List<String> theaters = List.of("PVRLULU", "ANUABHINAYA", "APSARA", "DHANYARAMYA", "AASHIRVAD");
        for(String theater : theaters){
            Theatre t = new Theatre(theater);
            theatreRepository.save(t);
        }

        log.info("Theaters created");

        City Kochi = cityRepository.findCityByName("Kochi");
        City Chry = cityRepository.findCityByName("CHRY");
        City TVLA = cityRepository.findCityByName("TVLA");

        List<Theatre> tvlaTheaters = new ArrayList<>(List.of(theatreRepository.findByName("AASHIRVAD")));
        List<Theatre> kochiTheaters = new ArrayList<>(List.of(theatreRepository.findByName("PVRLULU")));
        List<Theatre> chryTheaters = new ArrayList<>(List.of(theatreRepository.findByName("ANUABHINAYA"), theatreRepository.findByName("APSARA"),
                theatreRepository.findByName("DHANYARAMYA")));

        Kochi.setTheatres(kochiTheaters);
        Chry.setTheatres(chryTheaters);
        TVLA.setTheatres(tvlaTheaters);

        cityRepository.save(Kochi);
        cityRepository.save(Chry);
        cityRepository.save(TVLA);

        List<String> audis = List.of("PVRSCREEN1", "PVRSCREEN2", "AASHI1", "AASHI2");
        for(String audi : audis){
            Auditorium a = new Auditorium(audi);
            auditoriumRepository.save(a);
        }

        Theatre kochiTheater = theatreRepository.findByName("PVRLULU");
        Theatre tvlaTheater = theatreRepository.findByName("AASHIRVAD");

        List<Auditorium> pvrAudis = new ArrayList<>(List.of(auditoriumRepository.findByName("PVRSCREEN1"),auditoriumRepository.findByName("PVRSCREEN2")));
        List<Auditorium> aashiAudis = new ArrayList<>(List.of(auditoriumRepository.findByName("AASHI1"), auditoriumRepository.findByName("AASHI2")));

        kochiTheater.setAuditoriums(pvrAudis);
        tvlaTheater.setAuditoriums(aashiAudis);

        theatreRepository.save(kochiTheater);
        theatreRepository.save(tvlaTheater);

        List<String> seatNumbers = List.of("A1", "B1", "C1", "D1", "E1");
        int i=1;
        for(String seat : seatNumbers){
            Seat s = new Seat(++i,--i,seat,SeatType.GOLD,SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }

        Auditorium pvrScreen1 = auditoriumRepository.findByName("PVRSCREEN1");
        List<Seat> seats = seatRepository.findAll();
        pvrScreen1.setSeats(seats);


        List<String> shows = List.of("MorningShow", "Matinee", "FirstShow", "SecondShow");
        for(String show : shows){
            Show s = new Show(LocalDateTime.now(), LocalDateTime.now().plusMinutes(150));
            showRepository.save(s);
        }
        List<Show> showsInPvr = showRepository.findAll();
        pvrScreen1.setShows(showsInPvr);
        auditoriumRepository.save(pvrScreen1);

        for(i=1; i<=5; i++){
            ShowSeat s = new ShowSeat(1000, showRepository.findById(1).get(), seatRepository.findById(i).get(), ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);
        }
        List<ShowSeat> showSeats = showSeatRepository.findAll();

        Show MorningShow = showRepository.findById(1).get();
        Show Matinee = showRepository.findById(2).get();
        MorningShow.setShowSeat(showSeats);
        MorningShow.setAuditorium(pvrScreen1);
        Matinee.setAuditorium(pvrScreen1);


        Movie Titanic = new Movie("Titanic", "Historic Movie");
        Movie IronMan = new Movie("Iron Man", "Best Movie");
        movieRepository.save(Titanic);
        movieRepository.save(IronMan);

        MorningShow.setMovie(Titanic);
        Matinee.setMovie(IronMan);

        showRepository.save(MorningShow);
        showRepository.save(Matinee);
    }
}
