package com.dass.LearnMorseCode.controllers;


import com.dass.LearnMorseCode.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.security.*;
import java.security.*;


@Controller
public class MessageController {

    @Autowired
    ApplicationUserRepo applicationUserRepo;

    @Autowired
    MessageRepository messageRepo;

    @PostMapping("/message")
    public void sendMessage(String message, String username){
        ApplicationUser user = applicationUserRepo.findByUsername(username);
        Message m = new Message(message,user);
        messageRepo.save(m);
    }

    @GetMapping("/message")
    public String getMessagePage(){
        return "messagetest";
    }

    @GetMapping("/inbox")
    public String getInbox(Principal p, Model m){

        ApplicationUser user = applicationUserRepo.findByUsername(p.getName());

        m.addAttribute("messages",user.getInbox());

        return "inbox";
    }
}
