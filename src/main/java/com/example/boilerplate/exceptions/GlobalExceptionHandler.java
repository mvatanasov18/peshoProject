package com.example.boilerplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleUsernameAlreadyTakenException(UsernameAlreadyTakenException exception){
        return new ModelAndView("custom-error").addObject("message","Username already taken");
    }

}
