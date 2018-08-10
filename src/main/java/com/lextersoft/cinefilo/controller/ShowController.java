package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.model.entity.Show;
import com.lextersoft.cinefilo.model.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                             @RequestParam(name = "room", required = false) Integer room,
                             @RequestParam(name = "cinema", required = false) Integer cinema,
                             @RequestParam(name = "date", required = false) String date) throws ParseException {

        if (movie != null && room != null && cinema == null) {
            return showRepository.getByRoomAndMovie(room, movie);
        }
        else if (movie == null && room != null && cinema == null) {
            return showRepository.getByRoom(room);
        }
        else if (movie != null && room == null && cinema == null) {
            return showRepository.getByMovie(movie);
        }
        else if (movie != null && cinema != null && date != null) {
            return  showRepository.getByMovieAndCinema(movie, cinema, new SimpleDateFormat("dd-MM-yyyy").parse(date));
        }
        else if (movie == null && cinema != null && date == null) {
            return showRepository.getByCinema(cinema);
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
