package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.model.entity.Movie;
import com.lextersoft.cinefilo.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController implements IBasicController<Movie, Integer> {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping({"/", ""})
    public List<Movie> index(@RequestParam(name = "search", required = false) String search) {
        if (search == null)
            return movieRepository.getAll();
        else
            return movieRepository.getByName(search.replace(" ", "%"));
    }

    @GetMapping("/premieres")
    public List<Movie> getPremieres () {
        return movieRepository.getPremieres();
    }

    @GetMapping("/billboard")
    public List<Movie> getBillboard () {
        return movieRepository.getBillboard();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable(name = "id") Integer id) {
        return movieRepository.findById(id);
    }

    @PostMapping({"", "/"})
    public void save(@RequestBody Movie data) {
        movieRepository.save(data);
    }

    @PutMapping({"", "/"})
    public void update(@RequestBody Movie data) {
        movieRepository.update(data);
    }

    @DeleteMapping({"", "/"})
    public void delete(@RequestBody Movie data) {
        movieRepository.delete(data);
    }
}
