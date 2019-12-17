package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.domain.Cinema;
import com.lextersoft.cinefilo.service.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController implements IBasicController<Cinema, Integer> {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping({"", "/"})
    public List<Cinema> index(@RequestParam(name = "search", required = false) String search) {
        if (search == null) {
            return cinemaService.getAll();
        }
        else {
            return cinemaService.getByName(search);
        }
    }

    @GetMapping("/shows")
    public List<Cinema> getWithShows(@RequestParam(name = "movie") Integer movie, @RequestParam(name = "date") String date) throws ParseException {
        return cinemaService.getWithShows(movie, new SimpleDateFormat("dd-MM-yyyy").parse(date));
    }

    @GetMapping("/{id}")
    public Cinema findById(@PathVariable(name = "id") Integer id) {
        return cinemaService.findById(id).get();
    }


    @PostMapping({"", "/"})
    public void save(@RequestBody Cinema data) {
        cinemaService.save(data);
    }

    @PutMapping({"/", ""})
    public void update(@RequestBody Cinema data) {
        cinemaService.update(data);
    }

    @DeleteMapping({"", "/"})
    public void delete(@RequestBody Cinema data) {
        cinemaService.delete(data);
    }
}
