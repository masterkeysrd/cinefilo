package com.lextersoft.cinefilo.repository;

import com.lextersoft.cinefilo.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> getByName(String name);
}
