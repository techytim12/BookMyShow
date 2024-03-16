package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.model.City;
import com.scaler.BookMyShow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
