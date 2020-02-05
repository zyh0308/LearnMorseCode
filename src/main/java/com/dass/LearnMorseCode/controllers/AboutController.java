package com.dass.LearnMorseCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;
@Controller
public class AboutController {

    @GetMapping("/about")
    public String getAboutUs(Principal p, Model m){
        if(p != null){
            m.addAttribute("username", p.getName());
            m.addAttribute("action","/logout");
        } else {
            m.addAttribute("action","/login");

        }
        return "about";
    }
}
