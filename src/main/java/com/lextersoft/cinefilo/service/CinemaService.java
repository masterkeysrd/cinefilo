package com.lextersoft.cinefilo.service;

import com.lextersoft.cinefilo.domain.Cinema;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CinemaService {
    Optional<Cinema> findById(Integer id);
    List<Cinema> getAll();
    List<Cinema> getByName(String name);
    List<Cinema> getWithShows(Integer movie, Date date);
    void save(Cinema data);
    void update(Cinema data);
    void delete(Cinema data);
}
