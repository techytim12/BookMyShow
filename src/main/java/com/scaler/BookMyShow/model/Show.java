package com.scaler.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "SHOW_DETAILS")
public class Show extends BaseModel{

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @OneToMany
    private List<ShowSeat> showSeat;

    public Show() {
    }

    public Show(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

/*
* 1         M
* Show      showseat
* 1          1
* */
