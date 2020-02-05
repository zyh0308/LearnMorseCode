package com.dass.LearnMorseCode.controllers;

import com.dass.LearnMorseCode.LevelRepository;
import com.dass.LearnMorseCode.models.ApplicationUser;
import com.dass.LearnMorseCode.models.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.util.LinkedList;

@Controller
public class CreateController {

    @Autowired
    public LevelRepository levelRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationUserRepo applicationUserRepo;

    @GetMapping("/create")
    public String getCreate(){
        return "create";
    }

    @PostMapping("/create")
    public RedirectView registerUser(String username, String password){
        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password));
        applicationUserRepo.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new LinkedList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/profile");
    }
    @GetMapping("/level/{level_number}")
    public String showLevelQuestion(@PathVariable int level_number, Model m){
        switch(level_number){
            case 1:
                m.addAttribute("textHolder", "the");

                break;
            case 2:
                m.addAttribute("textHolder", "quick");
                break;
            case 3:
                m.addAttribute("textHolder", "brown");
                break;
            case 4:
                m.addAttribute("textHolder", "fox");
                break;
            case 5:
                m.addAttribute("textHolder", "jumps");
                break;
            case 6:
                m.addAttribute("textHolder", "over");
                break;
            case 7:
                m.addAttribute("textHolder", "the");
                break;
            case 8:
                m.addAttribute("textHolder", "lazy");
                break;
            case 9:
                m.addAttribute("textHolder", "dog");
                break;
            case 10:
                m.addAttribute("textHolder", "api call result comes here");
        }
        m.addAttribute("level_number", level_number);
    return "converter";
    }

    @PostMapping("level/{level_number}")
    public RedirectView getResult(String inputAnswer, String correctAnswer){
        return new RedirectView("/");
    }
}



