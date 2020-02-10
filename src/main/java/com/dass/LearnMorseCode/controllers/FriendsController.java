package com.dass.LearnMorseCode.controllers;


import com.dass.LearnMorseCode.models.ApplicationUser;
import com.dass.LearnMorseCode.models.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;


// looks good to me
@Controller
public class FriendsController {

    @Autowired
    private ApplicationUserRepo applicationUserRepo;

    @GetMapping("/friends")
    public String getCreate(Principal p, Model m){ // I would rename the getCreate to showFriends

        // Calling currently logged in username (me)
        if(p != null){
            m.addAttribute("username", p.getName());
            m.addAttribute("action","/logout");
        } else {
            m.addAttribute("action","/login");
        }

        // List to display all users in database
        m.addAttribute("allUsers", applicationUserRepo.findAll());

        return "friends";
    }

    @GetMapping("/friends/{id}")
    public String getAllFriends(@PathVariable long id, Principal p, Model d){
        ApplicationUser friendsList = applicationUserRepo.findById(id).get();
        ApplicationUser loggedInUser = applicationUserRepo.findByUsername(p.getName());
        d.addAttribute("friendsList", friendsList);
        d.addAttribute("loggedInUser", loggedInUser);
        return "/profile";
    }
}


