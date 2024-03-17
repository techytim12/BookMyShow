package com.scaler.BookMyShow.model;

import com.scaler.BookMyShow.model.constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "MOVIE")
public class Movie extends BaseModel {
    public Movie() {
    }

    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;
    @ManyToMany
    private List<Actor> actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;
}


/*
* 1         m
* Movie     Actor
* m          1
* */
