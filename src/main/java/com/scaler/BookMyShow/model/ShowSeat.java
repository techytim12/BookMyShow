package com.scaler.BookMyShow.model;

import com.scaler.BookMyShow.model.BaseModel;
import com.scaler.BookMyShow.model.Seat;
import com.scaler.BookMyShow.model.Show;
import com.scaler.BookMyShow.model.constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {

    private int price;
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;

}


/*
* 1             1
* ShowSeat      show
* M              1
*
* 1             1
* ShowSeat      seat
* M              1
* */