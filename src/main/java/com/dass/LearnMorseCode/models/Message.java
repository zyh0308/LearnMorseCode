package com.dass.LearnMorseCode.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany
    List<ApplicationUser> user;


    public Message(){

    }
    public Message(String content){
        this.content = content;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
