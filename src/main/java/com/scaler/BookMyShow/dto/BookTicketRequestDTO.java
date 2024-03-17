package com.scaler.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {

    private Integer userId;
    private List<Integer> showSeatIds;
}
