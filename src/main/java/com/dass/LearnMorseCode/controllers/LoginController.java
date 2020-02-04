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
    private ApplicationUserRepo applicationUserRepo;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/login/{id}")
    public RedirectView loginUser(String username, String password){

        ApplicationUser currentUser = applicationUserRepo.findByUsername(username);

        return new RedirectView("/profile/{id}");
    }
}
