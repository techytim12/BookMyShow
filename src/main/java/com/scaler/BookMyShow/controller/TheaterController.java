package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping("/theaters-list")
    public ResponseEntity getAllTheaters(){
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    @GetMapping("/theater/{theater_name}")
    public ResponseEntity getTheaterDetails(@PathVariable String theater_name){
        return ResponseEntity.ok(theaterService.getTheaterDetails(theater_name));
    }
}
