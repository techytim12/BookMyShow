package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.model.ShowSeat;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int id){
        return showSeatRepository.findById(id).get();
    }
}
