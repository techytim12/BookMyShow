package com.scaler.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "CITY")
public class City extends BaseModel{

    private String name;
    @OneToMany
    private List<Theatre> theatres;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }
}


/*
  1     m
* city  theatre
   1     1
* */