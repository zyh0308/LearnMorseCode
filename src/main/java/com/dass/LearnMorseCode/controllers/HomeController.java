package com.dass.LearnMorseCode.controllers;


import com.dass.LearnMorseCode.MorseCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;


@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Principal p, Model m){
//        MorseCode.morseToEnglish("");
        // This could be a helper function and many of the controllers could be combined
        if(p != null){
            m.addAttribute("username", p.getName());
            m.addAttribute("action","/logout");
        } else {
            m.addAttribute("action","/login");

        }
        return "home";
    }
    // Could remove commented out code
    // This can now be deleted
    @GetMapping("/audiotest")
    public String getAudioTest(){
        return "audiotest";
    }
}