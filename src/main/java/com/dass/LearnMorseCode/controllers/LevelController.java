package com.dass.LearnMorseCode.controllers;

import com.dass.LearnMorseCode.*; // delete unused package
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LevelController {
    @GetMapping("/morseToEnglish")
    public String morseToEnglish(Model m){
//        m.addAttribute("morse", Level.convertToMorseCode("sos"));
//        m.addAttribute("answer","sos"); // delete unused comments
        return "morseToEnglish";
    }
    @GetMapping("/englishToMorse")
    public String englishToMorse(Model m){
//        m.addAttribute("morse", Level.convertToMorseCode("sos"));
//        m.addAttribute("answer","sos"); // delete unused comments
        return "englishToMorse";
    }
}
