package com.lextersoft.cinefilo.model.service;

import com.lextersoft.cinefilo.model.entity.Cinema;
import com.lextersoft.cinefilo.model.repository.CinemaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class CinemaService implements CinemaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cinema findById(Integer id) {
        return entityManager
                .find(Cinema.class, id);
    }

    @Override
    public List<Cinema> getAll() {
        return entityManager
                .createNamedQuery("Cinema.getAll", Cinema.class)
                .getResultList();
    }

    @Override
    public List<Cinema> getByName(String name) {
        return entityManager
                .createNamedQuery("Cinema.getByName", Cinema.class)
                .setParameter("prm_name", name.replace(" ", "%"))
                .getResultList();
    }

    @Override
    public List<Cinema> getWithShows(Integer movie, Date date) {
        return entityManager
                .createNamedQuery("Cinema.getWithShows", Cinema.class)
                .setParameter("prm_movie", movie)
                .setParameter("prm_date", date)
                .getResultList();
    }

    @Override
    public void save(Cinema data) {
        entityManager.persist(data);
    }

    @Override
    public void update(Cinema data) {
        entityManager.merge(data);
    }

    @Override
    public void delete(Cinema data) {
        entityManager.remove(entityManager.contains(data) ? data: entityManager.merge(data));
    }
}
