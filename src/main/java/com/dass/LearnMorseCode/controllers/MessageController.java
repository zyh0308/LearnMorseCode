package com.dass.LearnMorseCode.controllers;

import com.dass.LearnMorseCode.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    @Autowired
    ApplicationUserRepo applicationUserRepo;

    @Autowired
    MessageRepository messageRepo;

    @PostMapping("/message")
    public void sendMessage(String message, String username){
        ApplicationUser user = applicationUserRepo.findByUsername(username);
        Message m = new Message(message);
    }

    @GetMapping("/message")
    public String getMessagePage(){
        return "messagetest";
    }
}
