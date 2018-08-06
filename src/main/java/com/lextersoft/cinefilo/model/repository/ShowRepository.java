package com.lextersoft.cinefilo.model.repository;

import com.lextersoft.cinefilo.model.entity.Show;

import java.util.Date;
import java.util.List;

public interface ShowRepository extends IRepository<Show, Integer> {
    List<Show>getByMovie(Integer movie);
    List<Show> getByRoom(Integer room);
    List<Show> getByRoomAndMovie(Integer room, Integer movie);
    List<Show> getByMovieAndCinema(Integer movie , Integer cinema, Date date);
}
