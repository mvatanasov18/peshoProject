package com.example.boilerplate.controllers;


import com.example.boilerplate.models.Address;
import com.example.boilerplate.models.Doctor;
import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.User;
import com.example.boilerplate.repositories.AddressRepository;
import com.example.boilerplate.repositories.DoctorRepository;
import com.example.boilerplate.repositories.HospitalRepository;
import com.example.boilerplate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
   private DoctorRepository doctorRepository;
    @GetMapping(value = {"/", "index"})
    public String getIndex() {
        return "index";
    }

    @GetMapping(value = {"/register"})
    public String getRegister(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("address",new Address());
        model.addAttribute("hospital",new Hospital());
        return "register";

    }
    @GetMapping(value = {"/login"})
    public String getLogin(Model model) {
        model.addAttribute("user",new User());
        return "login";

    }


    @PostMapping(value = {"/register"})
    public String postRegister(@ModelAttribute User user,@ModelAttribute Address address,@ModelAttribute Hospital hospital)
    {

        Doctor doctorShef=new Doctor();

        hospital.setAddress(address);
        user.setHospital(hospital);
        doctorShef.setUser(user);
        addressRepository.save(address);
        hospitalRepository.save(hospital);
        userRepository.save(user);
        doctorRepository.save(doctorShef);
        return "register";

    }
    @PostMapping(value = {"/login"})
    public String postLogin() {
        return "login";

    }
}
