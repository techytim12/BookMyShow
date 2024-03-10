package com.scaler.BookMyShow.model;

import com.scaler.BookMyShow.model.constant.PaymentStatus;
import com.scaler.BookMyShow.model.constant.PaymentMode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "PAYMENT")
public class Payment extends BaseModel {

    private LocalDateTime paymentTime;

    private double amount;

    private String referenceId;

    @ManyToOne
    private Ticket ticket;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
}


/*
1           1
Payment     Ticket
M            1
*/
