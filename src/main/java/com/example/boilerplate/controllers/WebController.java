package com.example.boilerplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebController {
    @GetMapping(value = {"/", "index"})
    public ModelAndView home() {
        ModelAndView page = new ModelAndView("index");

        return page;

    }
}
