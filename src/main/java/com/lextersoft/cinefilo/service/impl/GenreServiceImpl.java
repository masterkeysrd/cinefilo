package com.lextersoft.cinefilo.service.impl;

import com.lextersoft.cinefilo.domain.Genre;
import com.lextersoft.cinefilo.repository.GenreRepository;
import com.lextersoft.cinefilo.service.GenreService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreServiceImpl  implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> getByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public void save(Genre data) {
        genreRepository.save(data);
    }

    @Override
    public void update(Genre data) {
        genreRepository.save(data);
    }

    @Override
    public void delete(Genre data) {
       genreRepository.delete(data);
    }
}
