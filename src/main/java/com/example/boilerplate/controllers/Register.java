package com.example.boilerplate.controllers;

import com.example.boilerplate.models.Address;
import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.User;
import com.example.boilerplate.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/register")
public class Register {
    private final DoctorService doctorService;
    private final UserService userService;
    private final AddressService addressService;
    private final HospitalService hospitalService;
    private final NavbarService navbarService;

    @GetMapping
    public ModelAndView getRegister(HttpServletRequest request){
        return new ModelAndView("register").addObject("user",new User())
                .addObject("address",new Address())
                .addObject("hospital",new Hospital())
                .addObject("navElements",navbarService.getNavbar(request));
    }

}
