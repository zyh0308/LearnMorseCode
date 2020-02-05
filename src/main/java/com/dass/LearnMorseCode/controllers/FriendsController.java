package com.dass.LearnMorseCode.controllers;


import com.dass.LearnMorseCode.models.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;


@Controller
public class FriendsController {

    @Autowired
    private ApplicationUserRepo applicationUser;

    @GetMapping("/friends")
    public String getCreate(Principal p, Model m){

        if (p != null) {
            m.addAttribute("username", p.getName());
        }
        return "friends";
    }
}


