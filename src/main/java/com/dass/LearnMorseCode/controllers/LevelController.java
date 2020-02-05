package com.dass.LearnMorseCode.controllers;

import com.dass.LearnMorseCode.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LevelController {
    @GetMapping("mocklevel")
    public String getMockLevel(Model m){
        m.addAttribute("morse", Level.convertToMorseCode("sos"));
        return "mocklevel";
    }
}
