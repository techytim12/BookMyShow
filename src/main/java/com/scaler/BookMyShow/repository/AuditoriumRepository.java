package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.model.Auditorium;
import com.scaler.BookMyShow.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {

    Auditorium findByName(String name);
}
