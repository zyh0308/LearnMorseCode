package com.dass.LearnMorseCode;


// Should be inside of the models directory
// Could add spacing to improve readability
//
public class ApiQuote {
    String quoteText;
    public ApiQuote(String quoteText){
        this.quoteText = quoteText;
    }
    public String toString(){
        return String.format("QuoteText : %s", quoteText);
    }
}
