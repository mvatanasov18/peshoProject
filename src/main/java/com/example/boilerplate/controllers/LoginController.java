package com.example.boilerplate.controllers;

import com.example.boilerplate.exceptions.InvalidCredentialsException;
import com.example.boilerplate.models.Session;
import com.example.boilerplate.models.User;
import com.example.boilerplate.services.NavbarService;
import com.example.boilerplate.services.SessionService;
import com.example.boilerplate.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping(value = "/login")
@AllArgsConstructor
public class LoginController {
    private final UserService userService;
    private final SessionService sessionService;
    private final NavbarService navbarService;
    @GetMapping
    public ModelAndView getLogin(HttpServletRequest request){
        return new ModelAndView("/login").addObject("user",new User()).addObject("navElements",navbarService.getNavbar(request));

    }
    @PostMapping
    public ModelAndView postLogin(@ModelAttribute User loginUser, HttpServletResponse response){
        User user=userService.findUserByUsername(loginUser.getUsername());
        if(user!=null){
            if(userService.checkPassword(user,user.getPassword())){
                System.out.println("Password was correct");
                String id= UUID.randomUUID().toString();
                if(user.getSession()!=null){
                    sessionService.deleteSession(user.getSession());
                }
                Session session=new Session(id,"",new java.sql.Timestamp(new java.util.Date().getTime()),user);
                        user.setSession(session);
                if(sessionService.saveSession(session)!=null){
                    System.out.println("creating a cookie");
                    Cookie cookie=new Cookie("session",id);
                    cookie.setMaxAge(4*60*60);
                    cookie.setHttpOnly(true);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return new ModelAndView("redirect:/");
                }
                return new ModelAndView("custom-error");

            }
        }
        throw new InvalidCredentialsException();
    }
}
