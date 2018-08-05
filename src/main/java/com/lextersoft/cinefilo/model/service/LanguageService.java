package com.lextersoft.cinefilo.model.service;

import com.lextersoft.cinefilo.model.entity.Language;
import com.lextersoft.cinefilo.model.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LanguageService implements LanguageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Language findById(Integer id) {
        return entityManager.find(Language.class, id);
    }

    @Override
    public List<Language> getAll() {
        Query query = entityManager.createNamedQuery("Language.getAll", Language.class);
        return query.getResultList();
    }

    @Override
    public List<Language> getByName(String name) {
        Query query = entityManager.createNamedQuery("Language.getByName", Language.class);
        query.setParameter("prm_name", name);
        return query.getResultList();
    }

    @Override
    public void save(Language data) {
        entityManager.persist(data);
    }

    @Override
    public void update(Language data) {
        entityManager.merge(data);
    }

    @Override
    public void delete(Language data) {
        entityManager.remove(entityManager.contains(data) ? data: entityManager.merge(data));
    }
}
