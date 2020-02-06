package com.dass.LearnMorseCode.controllers;


import com.dass.LearnMorseCode.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.security.*;


@Controller
public class MessageController {

    @Autowired
    ApplicationUserRepo applicationUserRepo;

    @Autowired
    MessageRepository messageRepo;

    @GetMapping("/sendmessage")
    public String getMessagePage(){
        return "sendmessage";
    }

    @PostMapping("/sendmessage")
    public RedirectView sendMessage(String message, String username){
        ApplicationUser user = applicationUserRepo.findByUsername(username);
        Message m = new Message(message,user);
        messageRepo.save(m);
        return new RedirectView("/friends");
    }

//    @PostMapping("/login/{id}")
//    public RedirectView loginUser(String username, String password){
//
//        ApplicationUser currentUser = applicationUserRepo.findByUsername(username);
//
//        return new RedirectView("/profile/{id}");
//    }

    @GetMapping("/inbox")
    public String getInbox(Principal p, Model m){

        ApplicationUser user = applicationUserRepo.findByUsername(p.getName());

        m.addAttribute("messages",user.getInbox());

        return "inbox";
    }
}
