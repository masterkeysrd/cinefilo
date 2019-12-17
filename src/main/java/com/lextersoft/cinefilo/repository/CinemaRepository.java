package com.lextersoft.cinefilo.repository;

import com.lextersoft.cinefilo.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    List<Cinema> getWithShows(Integer movie, Date date);
    List<Cinema> getByName(String name);
}
