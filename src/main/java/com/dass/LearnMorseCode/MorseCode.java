package com.dass.LearnMorseCode;



import java.util.HashMap;

public class MorseCode {
    private static HashMap<String, String> dictionary;


        static {
        dictionary = new HashMap<>();
        dictionary.put(".-", "a");
        dictionary.put("-...","b");
        dictionary.put("-.-.","c");
        dictionary.put("-..","d");
        dictionary.put(".","e");
        dictionary.put("..-.","f");
        dictionary.put("--.","g");
        dictionary.put("....","h");
        dictionary.put("..","i");
        dictionary.put(".---","j");
        dictionary.put("-.-","k");
        dictionary.put(".-..","l");
        dictionary.put("--","m");
        dictionary.put("-.","n");
        dictionary.put("---","o");
        dictionary.put(".--.","p");
        dictionary.put("--.-","q");
        dictionary.put(".-.","r");
        dictionary.put("...","s");
        dictionary.put("-","t");
        dictionary.put("..-","u");
        dictionary.put("...-","v");
        dictionary.put(".--","w");
        dictionary.put("-..-","x");
        dictionary.put("-.--","y");
        dictionary.put("--..","z");
        dictionary.put(".----","1");
        dictionary.put("..---","2" );
        dictionary.put("...--","3");
        dictionary.put("....-","4");
        dictionary.put(".....","5");
        dictionary.put("-....","6");
        dictionary.put("--...","7");
        dictionary.put("---..","8");
        dictionary.put("----.","9");
        dictionary.put("-----","0");


    }

    public static void main(String[] args){
        morseToEnglish("-.-./---/--/.");
    }

    public static String morseToEnglish(String morse) {
        String[] charArray=morse.split("/");
        StringBuilder result= new StringBuilder();

        for (int i =0; i<charArray.length;i++){
            if (! dictionary.containsKey(charArray[i])){
                throw new IllegalArgumentException();
            }
            String english=dictionary.get(charArray[i]);
            result.append(english);
        }

        System.out.println(result.toString());
        return result.toString();


    }

//    public String morseToEnglishSentence(String sentence){
//        String[] sentenceArray=sentence.split("/");
//        StringBuilder result= new StringBuilder();
//        for (String morse:sentenceArray){
//            result.append(morseToEnglish(morse));
//        }
//        return result.toString();
//
//    }
}
