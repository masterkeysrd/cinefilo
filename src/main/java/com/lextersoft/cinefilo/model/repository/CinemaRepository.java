package com.lextersoft.cinefilo.model.repository;

import com.lextersoft.cinefilo.model.entity.Cinema;

import java.util.Date;
import java.util.List;

public interface CinemaRepository extends IRepository<Cinema, Integer>{
    List<Cinema> getWithShows(Integer movie, Date date);
}
