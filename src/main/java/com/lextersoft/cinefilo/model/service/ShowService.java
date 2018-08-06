package com.lextersoft.cinefilo.model.service;

import com.lextersoft.cinefilo.model.entity.Show;
import com.lextersoft.cinefilo.model.repository.ShowRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class ShowService implements ShowRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Show findById(Integer id) {
        return entityManager.find(Show.class, id);
    }

    @Override
    public List<Show> getAll() {
        return entityManager
                .createNamedQuery("Show.getAll", Show.class)
                .getResultList();
    }

    public List<Show> getByMovie(Integer movie) {
        Query query = entityManager.createNamedQuery("Show.getByMovie", Show.class);
        query.setParameter("prm_movie", movie);
        return query.getResultList();
    }

    public List<Show> getByRoom(Integer room) {
        Query query = entityManager.createNamedQuery("Show.getByRoom", Show.class);
        query.setParameter("prm_room", room);
        return query.getResultList();
    }

    public List<Show> getByRoomAndMovie(Integer room, Integer movie) {
        Query query = entityManager.createNamedQuery("Show.getByRoomAndMovie", Show.class);
        query.setParameter("prm_room", room);
        query.setParameter("prm_movie", movie);
        return query.getResultList();
    }

    @Override
    public List<Show> getByMovieAndCinema(Integer movie, Integer cinema, Date date) {
        Query query = entityManager.createNamedQuery("Show.getByMovieAndCinema", Show.class);
        query.setParameter("prm_movie", movie);
        query.setParameter("prm_cinema", cinema);
        query.setParameter("prm_date", date);
        return query.getResultList();
    }

    @Override
    public List<Show> getByName(String name) {
        return null;
    }

    @Override
    public void save(Show data) {
        entityManager.persist(data);
    }

    @Override
    public void update(Show data) {
        entityManager.merge(data);
    }

    @Override
    public void delete(Show data) {
        entityManager.remove(entityManager.contains(data) ? data: entityManager.merge(data));
    }
}
