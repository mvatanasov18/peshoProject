package com.example.boilerplate.controllers;


import com.example.boilerplate.services.NavbarService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class WebController {
   private final NavbarService navbarService;
   @GetMapping(value="/")
    public ModelAndView getIndex(HttpServletRequest request){
       return new ModelAndView("index");
   }
}
