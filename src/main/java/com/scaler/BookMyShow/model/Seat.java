package com.scaler.BookMyShow.model;

import com.scaler.BookMyShow.model.constant.SeatStatus;
import com.scaler.BookMyShow.model.constant.SeatType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SEAT")
public class Seat extends BaseModel{

    @Column(name = "`row`")
    private int row;

    private int col;

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    public Seat() {
    }

    public Seat(int row, int col, String seatNumber, SeatType seatType, SeatStatus status) {
        this.row = row;
        this.col = col;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.status = status;
    }
}
