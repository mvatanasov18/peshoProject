package com.example.boilerplate.controllers;

import com.example.boilerplate.exceptions.UserDoesNotHavePermissionException;
import com.example.boilerplate.models.Patient;
import com.example.boilerplate.models.Session;

import com.example.boilerplate.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "patientsMenu")
@AllArgsConstructor
public class PatientMenuController {
    private PatientService patientService;
    private SessionService sessionService;
    private CookieService cookieService;
    private RoleService roleService;
    private UserService userService;

    @GetMapping
    public ModelAndView getPatientsMenu(HttpServletRequest request){
        //todo check cookie and role

        return null;
    }
    @PostMapping
    public ModelAndView postPatient(@ModelAttribute Patient patient, HttpServletRequest request){
        //todo check patient's data and save
        if (cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("receptionist")) {

                patient.getUser().setHospital(session.getUser().getHospital());
                patient.getUser().hashPassword();
                userService.saveUser(patient.getUser());
                patientService.savePatient(patient);
                //return redirect
            }
        }
        //throw exception
        return null;
    }
    @PostMapping(value = "/update")
    public ModelAndView putStudent(@ModelAttribute Patient patient, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                patient.getUser().setHospital(session.getUser().getHospital());

                userService.saveUser(patient.getUser());
                patientService.savePatient(patient);
                return new ModelAndView("redirect:/students");
            }
        }
        throw new UserDoesNotHavePermissionException();
    }


    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteGroup( HttpServletRequest request, @PathVariable String id){
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("receptionist")) {
                String schoolId= session.getUser().getHospital().getId();
                if( patientService.checkPatientByIdAndHospitalId(id,schoolId)){
                    patientService.deleteById(id);
                    return new ModelAndView("redirect:/adminsMenu");
                }
            }
        }
       // throw new UserDoesNotHavePermissionException();
        return null;
    }
}
