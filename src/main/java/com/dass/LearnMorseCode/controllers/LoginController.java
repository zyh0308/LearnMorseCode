package com.dass.LearnMorseCode.controllers;


import com.dass.LearnMorseCode.models.ApplicationUser;
import com.dass.LearnMorseCode.models.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class LoginController {

    @Autowired
    // could improve readability by removing private
    private ApplicationUserRepo applicationUserRepo;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/login/{id}")
    // Login and profile controller could be combined and this is a bad route name.
    public RedirectView loginUser(String username, String password){

        ApplicationUser currentUser = applicationUserRepo.findByUsername(username);

        return new RedirectView("/profile/{id}");
    }
}
