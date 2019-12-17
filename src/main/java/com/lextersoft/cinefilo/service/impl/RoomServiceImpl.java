package com.lextersoft.cinefilo.service.impl;

import com.lextersoft.cinefilo.domain.Room;
import com.lextersoft.cinefilo.repository.RoomRepository;
import com.lextersoft.cinefilo.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;


    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return roomRepository.findById(id);
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getByName(String name) {
        return roomRepository.getByName(name);
    }

    @Override
    public void save(Room data) {
        roomRepository.save(data);
    }

    @Override
    public void update(Room data) {
        roomRepository.save(data);
    }

    @Override
    public void delete(Room data) {
        roomRepository.delete(data);
    }
}
