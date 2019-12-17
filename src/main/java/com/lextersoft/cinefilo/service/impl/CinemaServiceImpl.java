package com.lextersoft.cinefilo.service.impl;

import com.lextersoft.cinefilo.domain.Cinema;
import com.lextersoft.cinefilo.repository.CinemaRepository;
import com.lextersoft.cinefilo.service.CinemaService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Optional<Cinema> findById(Integer id) {
        return cinemaRepository.findById(id);
    }

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public List<Cinema> getByName(String name) {
        return cinemaRepository.getByName(name.replace(" ", "%"));
    }

    @Override
    public List<Cinema> getWithShows(Integer movie, Date date) {
        return cinemaRepository.getWithShows(movie, date);
    }

    @Override
    public void save(Cinema data) {
        cinemaRepository.save(data);
    }

    @Override
    public void update(Cinema data) {
        cinemaRepository.save(data);
    }

    @Override
    public void delete(Cinema data) {
        cinemaRepository.delete(data);
    }
}
