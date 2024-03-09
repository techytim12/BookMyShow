package com.scaler.BookMyShow.model;

import com.scaler.BookMyShow.model.constant.PaymentStatus;
import com.scaler.BookMyShow.model.constant.PaymentMode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private LocalDate paymentTime;

    private double amount;

    private String referenceId;

    @ManyToOne
    private Ticket ticket;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payementStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
}


/*
1           1
Payment     Ticket
M            1
*/
