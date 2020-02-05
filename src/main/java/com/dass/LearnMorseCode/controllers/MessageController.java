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
    public String sendMessage(String message, String username){
        return null;
    }
}
