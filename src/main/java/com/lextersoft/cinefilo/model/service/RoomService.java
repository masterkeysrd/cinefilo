package com.lextersoft.cinefilo.model.service;

import com.lextersoft.cinefilo.model.entity.Room;
import com.lextersoft.cinefilo.model.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RoomService implements RoomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Room findById(Integer id) {
        return entityManager
                .find(Room.class, id);
    }

    @Override
    public List<Room> getAll() {
        return entityManager
                .createNamedQuery("Room.getAll", Room.class)
                .getResultList();
    }

    @Override
    public List<Room> getByName(String name) {
        return entityManager
                .createNamedQuery("Room.getByName", Room.class)
                .setParameter("prm_name", name.replace(" ", "%"))
                .getResultList();
    }

    @Override
    public void save(Room data) {
        entityManager
                .persist(data);
    }

    @Override
    public void update(Room data) {
        entityManager
                .merge(data);
    }

    @Override
    public void delete(Room data) {
        entityManager
                .remove(entityManager.contains(data) ? data: entityManager.merge(data));
    }
}
