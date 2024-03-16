package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.model.City;
import com.scaler.BookMyShow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    Theatre findByName(String theaterName);
}
