package com.dass.LearnMorseCode.controllers;

import com.dass.LearnMorseCode.Level;
import com.dass.LearnMorseCode.LevelRepository;
import com.dass.LearnMorseCode.MorseCode;
import com.dass.LearnMorseCode.MorseCodeRepository;
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

import java.io.IOException;
import java.util.LinkedList;

import static com.dass.LearnMorseCode.Level.getQuoteFromApi;

@Controller
public class CreateController {

    @Autowired
    public LevelRepository levelRepository;
    @Autowired
    public MorseCodeRepository morseCodeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationUserRepo applicationUserRepo;

    @GetMapping("/create")
    public String getCreate() {
        return "create";
    }

    @PostMapping("/create")
    public RedirectView registerUser(String username, String password) {
        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password));
        applicationUserRepo.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new LinkedList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/profile");


    }

    @GetMapping("/level/{level_number}")
    public String showLevelQuestion(@PathVariable int level_number, Model m) throws IOException {
        switch (level_number) {
            case 1:
                m.addAttribute("answer", "the");
                m.addAttribute("morse", Level.convertToMorseCode("the"));
                break;
            case 2:
                m.addAttribute("answer", "quick");
                m.addAttribute("morse", Level.convertToMorseCode("quick"));

                break;
            case 3:
                m.addAttribute("answer", "brown");
                m.addAttribute("morse", Level.convertToMorseCode("brown"));

                break;
            case 4:
                m.addAttribute("answer", "fox");
                m.addAttribute("morse", Level.convertToMorseCode("fox"));

                break;
            case 5:
                m.addAttribute("answer", "jumps");
                m.addAttribute("morse", Level.convertToMorseCode("jumps"));

                break;
            case 6:
                m.addAttribute("answer", "over");
                m.addAttribute("morse", Level.convertToMorseCode("over"));

                break;
            case 7:
                m.addAttribute("answer", "the");
                m.addAttribute("morse", Level.convertToMorseCode("the"));

                break;
            case 8:
                m.addAttribute("answer", "lazy");
                m.addAttribute("morse", Level.convertToMorseCode("lazy"));

                break;
            case 9:
                m.addAttribute("answer", "dog");
                m.addAttribute("morse", Level.convertToMorseCode("dog"));

                break;
            case 10:
                m.addAttribute("answer", getQuoteFromApi());
                m.addAttribute("morse", Level.convertToMorseCode(Level.getQuoteFromApi()));

        }
        m.addAttribute("level_number", level_number);

        return "englishToMorse";
    }


    @PostMapping("/morseToEnglish")
    public String goToMorseToEnglish(int currentLevel, Model m) {
        System.out.println(currentLevel);
        switch (currentLevel) {
            case 1:
                m.addAttribute("answer", "the");
                m.addAttribute("morse", Level.convertToMorseCode("the"));

                break;
            case 2:
                m.addAttribute("answer", "quick");
                m.addAttribute("morse", Level.convertToMorseCode("quick"));
                break;
            case 3:
                m.addAttribute("answer", "brown");
                m.addAttribute("morse",Level.convertToMorseCode("brown"));

                break;
            case 4:
                m.addAttribute("answer", "fox");
                m.addAttribute("morse", Level.convertToMorseCode("fox"));

                break;
            case 5:
                m.addAttribute("answer", "jumps");
                m.addAttribute("morse", Level.convertToMorseCode("jumps"));

                break;
            case 6:
                m.addAttribute("answer", "over");
                m.addAttribute("morse",Level.convertToMorseCode("over"));

                break;
            case 7:
                m.addAttribute("answer", "the");
                m.addAttribute("morse",Level.convertToMorseCode("the"));

                break;
            case 8:
                m.addAttribute("answer", "lazy");
                m.addAttribute("morse",Level.convertToMorseCode("lazy"));

                break;
            case 9:
                m.addAttribute("answer", "dog");
                m.addAttribute("morse",Level.convertToMorseCode("dog"));

                break;


        }
        m.addAttribute("level_number", currentLevel);

        return ("morseToEnglish");
    }

}

