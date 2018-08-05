package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.model.entity.Cinema;
import com.lextersoft.cinefilo.model.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController implements IBasicController<Cinema, Integer> {

    @Autowired
    private CinemaRepository cinemaRepository;

    @GetMapping({"", "/"})
    public List<Cinema> index(@RequestParam(name = "search", required = false) String search) {
        if (search == null) {
            return cinemaRepository.getAll();
        }
        else {
            return cinemaRepository.getByName(search);
        }
    }

    @GetMapping("/{id}")
    public Cinema findById(@PathVariable(name = "id") Integer id) {
        return cinemaRepository.findById(id);
    }


    @PostMapping({"", "/"})
    public void save(@RequestBody Cinema data) {
        cinemaRepository.save(data);
    }

    @PutMapping({"/", ""})
    public void update(@RequestBody Cinema data) {
        cinemaRepository.update(data);
    }

    @DeleteMapping({"", "/"})
    public void delete(@RequestBody Cinema data) {
        cinemaRepository.delete(data);
    }
}
