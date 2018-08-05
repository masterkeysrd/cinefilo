package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.model.entity.Genre;
import com.lextersoft.cinefilo.model.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController implements IBasicController<Genre, Integer>{


    @Autowired
    private GenreRepository genreRepository;

    @GetMapping({"", "/"})
    public List<Genre> index(@RequestParam(name = "search", required = false) String search) {
       if (search == null)
           return  genreRepository.getAll();
       else
           return genreRepository.getByName(search.replace(" ", "%"));
    }


    @GetMapping("/{id}")
    public Genre findById(@PathVariable Integer id) {
        return genreRepository.findById(id);
    }

    @PostMapping({"", "/"})
    public void save(@RequestBody Genre data) {
        genreRepository.save(data);
    }

    @PutMapping("/")
    public void update(@RequestBody Genre data) {
        genreRepository.update(data);
    }

    @DeleteMapping("/")
    public void delete(@RequestBody Genre data){
        genreRepository.delete(data);
    }
}
