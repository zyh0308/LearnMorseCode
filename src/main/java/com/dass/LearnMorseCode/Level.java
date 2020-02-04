package com.dass.LearnMorseCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Level {
    String toBeMorseCoded = "";
    int levelTracker = 0;

    public Level() {
        this.toBeMorseCoded = toBeMorseCoded;
        this.levelTracker = 0;
    }

    public static void main(String [] args){
        convertToMorseCode("hr ay dhdhf hjfhfh hfdhfh hfhfh hfhfh");
    }

    public static String convertToMorseCode(String regularText){
        char [] reg = regularText.toUpperCase().toCharArray();  //converts to uppercase and array of chars.
//                .toCharArray();


        String [] values = {".-","-...","-.-.","-..",".","..-.","--.", "....","..",".---", "-.-",".-..","--","-.", "---",".--.","--.-",".-.", "...","-",
                "..-","...-",".--","-..-","-.--","--..",     "-----", ".----","..---","...--","....-",".....","-....","--...","---..","----."};

        char [] keys = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
        String answers = "";
        int reset;
        for(int x = 0; x < reg.length; x++){
            reset =0;
            for(int y = 0; y < keys.length; y++) {
                if (reg[x] == keys[y]) {
                    answers += values[y] + "/" ;
                }
                else if(reg[x] == ' ' && reset <= 1){
                    reset++;
                    answers+= " ";
                }
            }
        }
        System.out.println("answers is " + answers);
        return  answers;
    }
}
