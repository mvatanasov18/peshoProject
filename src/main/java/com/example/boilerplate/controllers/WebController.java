package com.example.boilerplate.controllers;


import com.example.boilerplate.models.Address;
import com.example.boilerplate.models.Doctor;
import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.User;
import com.example.boilerplate.repositories.AddressRepository;
import com.example.boilerplate.repositories.DoctorRepository;
import com.example.boilerplate.repositories.HospitalRepository;
import com.example.boilerplate.repositories.UserRepository;
import com.example.boilerplate.services.NavbarService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class WebController {
   private final NavbarService navbarService;
   @GetMapping(value="/")
    public ModelAndView getIndex(HttpServletRequest request){
       return new ModelAndView("index").addObject("navElements",navbarService.getNavbar(request));
   }
}
