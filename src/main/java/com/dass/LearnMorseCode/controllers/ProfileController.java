package com.dass.LearnMorseCode.controllers;


import com.dass.LearnMorseCode.models.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

// This and login controller should all just be in the user controller. And it could use a helper function to reduce
// repeated code.
@Controller
public class ProfileController {

    @Autowired
    private ApplicationUserRepo applicationUser;

    @GetMapping("/profile")
    public String getCreate(Principal p, Model m){

        if(p != null){
            m.addAttribute("username", p.getName());
            m.addAttribute("action","/logout");
        } else {
            m.addAttribute("action","/login");
        }
        return "profile";
    }
}

