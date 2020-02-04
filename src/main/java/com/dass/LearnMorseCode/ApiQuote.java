package com.dass.LearnMorseCode;

public class ApiQuote {
    String quoteText;
    public ApiQuote(String quoteText){
        this.quoteText = quoteText;
    }
    public String toString(){
        return String.format("QuoteText : %s", quoteText);
    }
}
