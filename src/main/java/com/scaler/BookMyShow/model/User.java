package com.scaler.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "BMS_USER")
public class User extends BaseModel{

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Ticket> tickets;
}
