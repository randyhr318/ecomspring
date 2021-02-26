package com.tts.ecomspring.controller;

import com.tts.ecomspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthenticationController {
@Autowired
    private UserService userService;

@GetMapping(value = "/login")
    public String login(){
    return "login"
}
@PostMapping(value = "/signin")
    public String signin(@Valid User user, @RequestParam String submit, BindingResult bindingResult, HttpServletRequest request) throws ServletException {
    String password = user.getPassword();
    if(submit.equals("up")){
        if(userService.findByUsername(user.getUsername()) == null){

        }
    }
}
}
