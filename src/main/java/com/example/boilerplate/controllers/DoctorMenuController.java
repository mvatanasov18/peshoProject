package com.example.boilerplate.controllers;


import com.example.boilerplate.exceptions.UserDoesNotHavePermissionException;
import com.example.boilerplate.models.Doctor;
import com.example.boilerplate.models.Patient;
import com.example.boilerplate.models.Session;
import com.example.boilerplate.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "doctorsMenu")
@AllArgsConstructor
public class DoctorMenuController {
    private DoctorService doctorService;
    private SessionService sessionService;
    private CookieService cookieService;
    private RoleService roleService;
    private UserService userService;

    @GetMapping
    public ModelAndView getDoctorsMenu(HttpServletRequest request){
        //todo check cookie and role

        return null;
    }
    @PostMapping
    public ModelAndView postDoctor(@ModelAttribute Doctor doctor, HttpServletRequest request){
        //todo check patient's data and save
        if (cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("receptionist")) {

                doctor.getUser().setHospital(session.getUser().getHospital());
                doctor.getUser().hashPassword();
                userService.saveUser(doctor.getUser());
                doctorService.saveDoctor(doctor);
                //return redirect
            }
        }
        //throw exception
        return null;
    }
    @PostMapping(value = "/update")
    public ModelAndView putDoctor(@ModelAttribute Doctor doctor, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("receptionist")) {
                doctor.getUser().setHospital(session.getUser().getHospital());

                userService.saveUser(doctor.getUser());
                doctorService.saveDoctor(doctor);
                return new ModelAndView("redirect:/doctors");
            }
        }
        throw new UserDoesNotHavePermissionException();
    }


    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteDoctor( HttpServletRequest request, @PathVariable String id){
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("receptionist")) {
                String schoolId= session.getUser().getHospital().getId();
                if( doctorService.checkDoctorByIdAndHospitalId(id,schoolId)){
                    doctorService.deleteById(id);
                    return new ModelAndView("redirect:/doctorsMenu");
                }
            }
        }
        // throw new UserDoesNotHavePermissionException();
        return null;
    }

}
