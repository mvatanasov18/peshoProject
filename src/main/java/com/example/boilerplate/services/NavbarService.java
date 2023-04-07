package com.example.boilerplate.services;

import com.example.boilerplate.models.Navbar;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
@AllArgsConstructor
public class NavbarService {

    private Map<String, String> setMapForDoctor() {
        Map<String, String> elements = new LinkedHashMap<>();
        elements.put("/patientsMenu", "Меню за пациенти");
        elements.put("/appointmentsMenu", "Меню за срещи");
        elements.put("/profile", "Профил");
        elements.put("/login/logout", "Излез");

        return elements;
    }

    private Map<String, String> setMapForReceptionist() {
        Map<String, String> elements = new LinkedHashMap<>();
        elements.put("/patientsMenu", "Меню за пациенти");
        elements.put("/appointmentsMenu", "Меню за срещи");
        elements.put("/profile", "Профил");
        elements.put("/login/logout", "Излез");

        return elements;
    }

    private Map<String, String> setMapForReceptionist() {
        Map<String, String> elements = new LinkedHashMap<>();
        elements.put("/patientsMenu", "Меню за пациенти");
        elements.put("/appointmentsMenu", "Меню за срещи");
        elements.put("/profile", "Профил");
        elements.put("/login/logout", "Излез");

        return elements;
    }

    private Navbar getNavbarByRoleName(String roleName) {

        return switch (roleName) {
            case "doctor" -> new Navbar(setMapForDoctor());
            case "receptionist" -> new Navbar(setMapForReceptionist());
            case "admin" -> new Navbar(setMapForAdmin());
            case "teacher" -> new Navbar(setMapForTeacher());
            default -> null;
        };

    }


    public Navbar getNavbar(String sessionId, SessionService sessionService) {

        if (sessionId.equals("")) {
            Map<String, String> temp = new TreeMap<>();
            temp.put("/login", "Вписване");
            temp.put("/register", "Регистрация");
            temp.put("/", "Начало");
            return new Navbar(temp);


        } else {
            return getNavbarByRoleName(sessionService.findById(sessionId).getRoleName());
        }
    }

}
