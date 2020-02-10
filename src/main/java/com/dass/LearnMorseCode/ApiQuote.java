package com.dass.LearnMorseCode;

public class ApiQuote {
    // I would set the property quoteText to private and have a getter and setter so other classes dont have access to this class.
    String quoteText;
    public ApiQuote(String quoteText){
        this.quoteText = quoteText;
    }
    public String toString(){
        return String.format("QuoteText : %s", quoteText);
    }
}
