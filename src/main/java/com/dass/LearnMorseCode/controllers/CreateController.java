package com.dass.LearnMorseCode.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateController {

    @GetMapping("/create")
    public String getCreate(){
        return "create";
    }

}


