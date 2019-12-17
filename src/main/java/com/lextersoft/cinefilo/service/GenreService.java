package com.lextersoft.cinefilo.service;

import com.lextersoft.cinefilo.domain.Genre;
import com.lextersoft.cinefilo.repository.GenreRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> findById(Integer id);
    List<Genre> getAll();
    List<Genre> getByName(String name);
    void save(Genre data);
    void update(Genre data);
    void delete(Genre data);
}
