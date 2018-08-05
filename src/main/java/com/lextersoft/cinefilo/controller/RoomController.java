package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.model.entity.Room;
import com.lextersoft.cinefilo.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements IBasicController<Room, Integer>{

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping({"", "/"})
    public List<Room> index(@RequestParam(name = "search", required = false) String search) {
        if (search == null)
            return roomRepository.getAll();
        else
            return roomRepository.getByName(search);
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable(name = "id") Integer id) {
        return roomRepository.findById(id);
    }

    @PostMapping({"", "/"})
    public void save(@RequestBody Room data) {
        roomRepository.save(data);
    }

    @PutMapping({"", "/"})
    public void update(@RequestBody Room data) {
        roomRepository.update(data);
    }

    @DeleteMapping({"", "/"})
    public void delete(@RequestBody Room data) {
        roomRepository.delete(data);
    }
}
