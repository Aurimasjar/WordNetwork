package com.company;

public class Main {

    public static void main(String[] args) {
        Text text = new Text();
        text.readTextFromFile();
        //text.printText();
        text.splitTextToSentences();
        //text.printSentences();
        for(int i = 0; i < text.getSentenceCount(); i++) {
            text.getSentence(i).splitSentenceToWords();
        }

        text.getSentence(0).printWords();
        System.out.println();
        text.getSentence(1).printWords();
        System.out.println();
        text.getSentence(2).printWords();
        System.out.println();
        text.getSentence(3).printWords();
        System.out.println();
        text.getSentence(4).printWords();

    }
}
