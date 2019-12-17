package com.lextersoft.cinefilo.service;

import com.lextersoft.cinefilo.domain.Room;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public interface RoomService {

    Optional<Room> findById(Integer id);
    List<Room> getAll();
    List<Room> getByName(String name);
    void save(Room data);
    void update(Room data);
    void delete(Room data);
}
