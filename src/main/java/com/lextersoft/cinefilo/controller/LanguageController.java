package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.model.entity.Language;
import com.lextersoft.cinefilo.model.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController implements IBasicController<Language, Integer>{

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping({"/", ""})
    public List<Language> index(@RequestParam(name = "search", required = false) String search) {
        if (search == null)
            return languageRepository.getAll();
        else
            return languageRepository.getByName(search.replace(" ", "%"));
    }

    @GetMapping("/{id}")
    public Language findById(@PathVariable(name = "id") Integer id) {
        return languageRepository.findById(id);
    }

    @PostMapping({"", "/"})
    public void save(@RequestBody Language data) {
        languageRepository.save(data);
    }

    @PutMapping({"", "/"})
    public void update(@RequestBody Language data) {
        languageRepository.update(data);
    }

    @DeleteMapping({"", "/"})
    public void delete(@RequestBody Language data) {
        languageRepository.delete(data);
    }
}
