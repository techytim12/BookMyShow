package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.model.Theatre;
import com.scaler.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheatreRepository theatreRepository;
    public List<Theatre> getAllTheaters(){
        return theatreRepository.findAll();
    }

    public Theatre getTheaterDetails(String theater_name){
        return theatreRepository.findByName(theater_name);
    }
}
