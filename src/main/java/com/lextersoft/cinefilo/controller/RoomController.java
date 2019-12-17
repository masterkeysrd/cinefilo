package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.domain.Room;
import com.lextersoft.cinefilo.repository.RoomRepository;
import com.lextersoft.cinefilo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements IBasicController<Room, Integer>{

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping({"", "/"})
    public List<Room> index(@RequestParam(name = "search", required = false) String search) {
        if (search == null)
            return roomService.getAll();
        else
            return roomService.getByName(search);
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable(name = "id") Integer id) {
        return roomService.findById(id).get();
    }

    @PostMapping({"", "/"})
    public void save(@RequestBody Room data) {
        roomService.save(data);
    }

    @PutMapping({"", "/"})
    public void update(@RequestBody Room data) {
        roomService.update(data);
    }

    @DeleteMapping({"", "/"})
    public void delete(@RequestBody Room data) {
        roomService.delete(data);
    }
}
