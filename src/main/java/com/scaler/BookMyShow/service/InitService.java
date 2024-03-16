package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.dto.CityResponseDTO;
import com.scaler.BookMyShow.model.City;
import com.scaler.BookMyShow.model.Theatre;
import com.scaler.BookMyShow.repository.CityRepository;
import com.scaler.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TheatreRepository theatreRepository;

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
        /*Theatre t1 = new Theatre("PVR LULU");
        Theatre t2 = new Theatre("ANU ABHINAYA");
        Theatre t3 = new Theatre("APSARA");
        Theatre t4 = new Theatre("DHANYA RAMYA");
        Theatre t5 = new Theatre("AASHIRVAD");*/
        for(String theater : theaters){
            Theatre t = new Theatre(theater);
            theatreRepository.save(t);
        }

        City Kochi = cityRepository.findCityByName("Kochi");
        City Chry = cityRepository.findCityByName("CHRY");
        City TVLA = cityRepository.findCityByName("TVLA");

        /*List<Theatre> kochiTheaters = new ArrayList<>();*/
        List<Theatre> tvlaTheaters = new ArrayList<>(List.of(theatreRepository.findByName("AASHIRVAD")));

        List<Theatre> kochiTheaters = new ArrayList<>(List.of(theatreRepository.findByName("PVRLULU")));

        /*kochiTheaters.add(theatreRepository.findByName("PVRLULU"));*/
        List<Theatre> chryTheaters = new ArrayList<>(List.of(theatreRepository.findByName("ANUABHINAYA"), theatreRepository.findByName("APSARA"),
                theatreRepository.findByName("DHANYARAMYA")));
        /*chryTheaters.add(theatreRepository.findByName("ANUABHINAYA"));
        chryTheaters.add(theatreRepository.findByName("APSARA"));
        chryTheaters.add(theatreRepository.findByName("DHANYARAMYA"));*/
        /*tvlaTheaters.add(theatreRepository.findByName("AASHIRVAD"));*/

        Kochi.setTheatres(kochiTheaters);
        Chry.setTheatres(chryTheaters);
        TVLA.setTheatres(tvlaTheaters);

        cityRepository.save(Kochi);
        cityRepository.save(Chry);
        cityRepository.save(TVLA);
    }
}
