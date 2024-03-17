package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exception.SeatNotAvailableException;
import com.scaler.BookMyShow.model.ShowSeat;
import com.scaler.BookMyShow.model.Ticket;
import com.scaler.BookMyShow.model.constant.ShowSeatStatus;
import com.scaler.BookMyShow.model.constant.TicketStatus;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import com.scaler.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TicketService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private TicketRepository ticketRepository;

    public String greet(){
        return "Hello-World";
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(int userId, List<Integer> showSeatIds){

        for(int showSeatId : showSeatIds){
            ShowSeat showSeat = showSeatService.getShowSeat(showSeatId);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Selected seats not available");
            }
        }

        for(int showSeatId : showSeatIds){
            showSeatService.getShowSeat(showSeatId).setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeatService.getShowSeat(showSeatId));
        }

        payment();

        Ticket ticket = new Ticket();
        ticket.setShowSeats(printTicket(showSeatIds));
        ticket.setTimeOfBooking(LocalDateTime.now());
        double totalAmount = 0;
        for(int showSeatId : showSeatIds){
            totalAmount += showSeatService.getShowSeat(showSeatId).getPrice();
        }
        ticket.setTotalAmount(totalAmount);
        ticket.setStatus(TicketStatus.BOOKED);

        ticket.setShow(showSeatService.getShowSeat(showSeatIds.get(0)).getShow());

        ticketRepository.save(ticket);
        return ticket;
    }

    private List<ShowSeat> printTicket(List<Integer> showSeatIds) {
        List<ShowSeat> bookedSeats = new ArrayList<>();
        for(int showSeatId : showSeatIds){
            bookedSeats.add(showSeatService.getShowSeat(showSeatId));
        }
        return bookedSeats;
    }

    private void payment() {
    }
}
