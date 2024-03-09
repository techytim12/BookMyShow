package com.scaler.BookMyShow.model;

import com.scaler.BookMyShow.model.constant.AuditoriumFeature;
import com.scaler.BookMyShow.model.constant.AuditoriumStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{

    private String name;
    private int capacity;

    @OneToMany
    private List<Show> shows;

    @OneToMany
    private List<Seat> seats;

    @ElementCollection // >since enum is a list
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;

    @Enumerated(EnumType.STRING)
    private AuditoriumStatus status;
}
