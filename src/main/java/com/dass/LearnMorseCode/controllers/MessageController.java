package com.dass.LearnMorseCode.controllers;
import com.dass.LearnMorseCode.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.security.*;
import org.springframework.web.servlet.view.RedirectView;


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
    public RedirectView sendMessage(String message, String username, Principal p){
        ApplicationUser user = applicationUserRepo.findByUsername(username);
        Message m = new Message(message,user,p.getName());
        messageRepo.save(m);
        return new RedirectView("/friends");
    }

    @GetMapping("/inbox")
    public String getInbox(Principal p, Model m){

        if(p != null){
            m.addAttribute("username", p.getName());
            m.addAttribute("action","/logout");
        } else {
            m.addAttribute("action","/login");

        }

        ApplicationUser user = applicationUserRepo.findByUsername(p.getName());

        m.addAttribute("messages",user.getInbox());

        return "inbox";
    }
}
