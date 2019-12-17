package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.domain.Genre;
import com.lextersoft.cinefilo.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController implements IBasicController<Genre, Integer>{

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }


    @GetMapping({"", "/"})
    public List<Genre> index(@RequestParam(name = "search", required = false) String search) {
       if (search == null)
           return  genreService.getAll();
       else
           return genreService.getByName(search.replace(" ", "%"));
    }


    @GetMapping("/{id}")
    public Genre findById(@PathVariable Integer id) {
        return genreService.findById(id).get();
    }

    @PostMapping({"", "/"})
    public void save(@RequestBody Genre data) {
        genreService.save(data);
    }

    @PutMapping("/")
    public void update(@RequestBody Genre data) {
        genreService.update(data);
    }

    @DeleteMapping("/")
    public void delete(@RequestBody Genre data){
        genreService.delete(data);
    }
}
