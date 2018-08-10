package com.lextersoft.cinefilo.model.service;

import com.lextersoft.cinefilo.model.entity.Movie;
import com.lextersoft.cinefilo.model.repository.MovieRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class MovieService implements MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Movie findById(Integer id) {
        return entityManager
                .find(Movie.class, id);
    }

    @Override
    public List<Movie> getAll() {
        return entityManager
                .createNamedQuery("Movie.getAll", Movie.class)
                .getResultList();
    }

    @Override
    public List<Movie> getByName(String name) {
        return entityManager
                .createNamedQuery("Movie.getByName", Movie.class)
                .setParameter("prm_name", name)
                .getResultList();
    }

    @Override
    public List<Movie> getPremieres() {
        return entityManager
                .createNamedQuery("Movie.getPremieres", Movie.class)
                .setParameter("prm_date", DateUtils.addWeeks(new Date(), -2))
                .getResultList();
    }

    @Override
    public List<Movie> getBillboard() {
        return entityManager
                .createNamedQuery("Movie.getBillboard", Movie.class)
                .getResultList();
    }

    @Override
    public void save(Movie data) {
        entityManager.persist(data);
    }

    @Override
    public void update(Movie data) {
        entityManager.merge(data);
    }

    @Override
    public void delete(Movie data) {
        entityManager
                .remove(entityManager.contains(data) ? data: entityManager.merge(data));
    }
}
