package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Sentence {
    String sentence;
    ArrayList<String> word;


    Sentence(String x) {
        sentence = x;
        //word = new ArrayList<>();
    }

    public void setString(String x) { sentence = x; }
    public String getString() {return sentence; }

    public void setWord(String x, int pos) { word.set(pos, x); }
    public String getSentence(int pos) { return word.get(pos); }

    public void splitSentenceToWords() {
        word = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
        clearMarksFromWords();
    }

    public void clearMarksFromWords() {
        for(int i = 0; i < word.size(); i++) {
            word.set(i, word.get(i).replaceAll("[^\\p{L}\\p{N}]+", ""));
            System.out.println(word.get(i));
        }
    }

    public void printWords() {
        for(var s : word) {
            System.out.println(s);
        }
    }


}
