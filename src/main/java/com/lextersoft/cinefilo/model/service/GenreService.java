package com.lextersoft.cinefilo.model.service;

import com.lextersoft.cinefilo.model.entity.Genre;
import com.lextersoft.cinefilo.model.repository.GenreRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GenreService implements GenreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Genre findById(Integer id) {
        return entityManager
                .find(Genre.class, id);
    }

    @Override
    public List<Genre> getAll() {
        return entityManager
                .createNamedQuery("Genre.getAll", Genre.class)
                .getResultList();
    }

    @Override
    public List<Genre> getByName(String name) {
        return entityManager
                .createNamedQuery("Genre.getByName", Genre.class)
                .setParameter("prm_name", name)
                .getResultList();
    }

    @Override
    public void save(Genre data) {
        entityManager.persist(data);
    }

    @Override
    public void update(Genre data) {
        entityManager.merge(data);
    }

    @Override
    public void delete(Genre data) {
        entityManager
                .remove(entityManager.contains(data) ? data : entityManager.merge(data));
    }
}
