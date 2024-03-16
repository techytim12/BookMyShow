package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.model.Actor;
import com.scaler.BookMyShow.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
