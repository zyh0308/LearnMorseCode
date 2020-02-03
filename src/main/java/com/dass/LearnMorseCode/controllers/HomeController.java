package com.dass.LearnMorseCode.controllers;


import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }
}
