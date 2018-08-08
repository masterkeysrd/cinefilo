package com.lextersoft.cinefilo.model.repository;

import com.lextersoft.cinefilo.model.entity.Movie;

import java.util.List;

public interface MovieRepository extends IRepository<Movie, Integer> {
    List<Movie> getPremieres();
    List<Movie> getBillboard();
}