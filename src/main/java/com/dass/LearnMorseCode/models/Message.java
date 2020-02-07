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

    String sender;

    public Message(){

    }

    public Message(String content, ApplicationUser user,String sender){
        this.content = content;
        this.user = user;
        this.sender = sender;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
