package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.model.entity.Show;
import com.lextersoft.cinefilo.model.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController implements IBasicController<Show, Integer> {

    @Autowired
    private ShowRepository showRepository;

    @Override
    public List<Show> index(String search) {
        return null;
    }

    @GetMapping({"/", ""})
    public List<Show> search(@RequestParam(name = "movie", required = false) Integer movie,
                             @RequestParam(name = "room", required = false) Integer room) {
        if (movie != null && room != null) {
            return showRepository.getByRoomAndMovie(room, movie);
        }
        else if (movie == null && room != null) {
            return showRepository.getByRoom(room);
        }
        else if (movie != null && room == null) {
            return showRepository.getByMovie(movie);
        }
        return showRepository.getAll();
    }

    @GetMapping("/{id}")
    public Show findById(@PathVariable(name = "id") Integer id) {
        return showRepository.findById(id);
    }

    @PostMapping({"/", ""})
    public void save(@RequestBody Show data) {
        showRepository.save(data);
    }

    @PutMapping({"/", ""})
    public void update(@RequestBody Show data) {
        showRepository.update(data);
    }

    @DeleteMapping({"/", ""})
    public void delete(@RequestBody Show data) {
        showRepository.delete(data);
    }
}
