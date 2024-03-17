package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.dto.BookTicketRequestDTO;
import com.scaler.BookMyShow.dto.BookTicketResponseDTO;
import com.scaler.BookMyShow.model.Movie;
import com.scaler.BookMyShow.model.Show;
import com.scaler.BookMyShow.model.ShowSeat;
import com.scaler.BookMyShow.model.Ticket;
import com.scaler.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/book-ticket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequestDTO ticketRequestDTO){
        Ticket bookedTicket = ticketService.bookTicket(ticketRequestDTO.getUserId(),
                ticketRequestDTO.getShowSeatIds());

        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
        responseDTO.setId(bookedTicket.getId());
        responseDTO.setLocalDateTime(bookedTicket.getTimeOfBooking());
        responseDTO.setAmount(bookedTicket.getTotalAmount());

        List<ShowSeat> bookedSeats = bookedTicket.getShowSeats();
        List<Integer> bookedShowSeatIds = new ArrayList<>();

        for(ShowSeat bookedSeat : bookedSeats){
            bookedShowSeatIds.add(bookedSeat.getId());
        }

        responseDTO.setShowSeats(bookedShowSeatIds);
        Movie movie = bookedTicket.getShow().getMovie();
        responseDTO.setMovieName(movie.getName());

        return ResponseEntity.ok(responseDTO);
    }
}
