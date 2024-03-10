package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @GetMapping("/hello")
    public ResponseEntity<String> greet(){
        String greet = ticketService.greet();
        System.out.println(ResponseEntity.ok(greet));
        return ResponseEntity.ok(greet);
    }
}
