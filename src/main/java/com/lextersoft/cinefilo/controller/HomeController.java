package com.lextersoft.cinefilo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {

    @GetMapping({"/", "", "/index"})
    public String index() {
        return "Welcome to CineFilo";
    }
}
