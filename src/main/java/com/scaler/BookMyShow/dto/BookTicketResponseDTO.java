package com.scaler.BookMyShow.dto;


import com.scaler.BookMyShow.model.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BookTicketResponseDTO {

    private int id;
    private LocalDateTime localDateTime;
    private double amount;
    private List<Integer> showSeats;
    private String movieName;
}
