package com.dass.LearnMorseCode.models;


import com.dass.LearnMorseCode.*;
import javax.persistence.*;
import java.util.*;


@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    ApplicationUser user;


    public Message(){

    }

    public Message(String content, ApplicationUser user){
        this.content = Level.convertToMorseCode(content);
        this.user = user;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public long getId() {

        return id;
    }
}
