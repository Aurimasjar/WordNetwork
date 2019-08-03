package com.company;

import java.util.ArrayList;
import java.io.*;

public class Text {
    private String text;
    private ArrayList<Sentence> sentence;
    private ArrayList<Character> lithuanianSymbols = new ArrayList<>();

    public void setText(String x) { text = x; }
    public String getText() { return text; }

    public void setSentence(String x, int pos) { sentence.set(pos, new Sentence(x)); }
    public void setSentence(Sentence x, int pos) { sentence.set(pos, x); }
    public Sentence getSentence(int pos) { return sentence.get(pos); }
    public int getSentenceCount() { return sentence.size(); }

    public Text() {
        text = "";
        sentence = new ArrayList<>();
        formLithuanianSymbolsList();
    }

    public void readTextFromFile() {
        try {
        File file = new File("C:\\Programavimas\\Word Network\\file\\text.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            text += st/* + System.lineSeparator()*/;
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printText() {
        System.out.println(text);
    }

    public void printSentences() {
        for(var s : sentence) {
            System.out.println(s.getString());
        }
    }

    public void splitTextToSentences() {
        int sentenceBeginningPosition = 0;
        boolean sentenceEnd = false;
        for (int i = 0; i < text.length(); i++) {
            if((text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!' || text.charAt(i) == '…')) {
                sentenceEnd = true;
            }
            while (sentenceEnd) {
                if((i >= text.length()))
                {
                    sentence.add(new Sentence(text.substring(sentenceBeginningPosition, i)));
                    sentenceBeginningPosition = i;
                    break;
                }
                else if(sentenceEnd && (text.charAt(i) == ' ' || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') || lithuanianSymbols.contains(text.charAt(i)))) {
                    sentence.add(new Sentence(text.substring(sentenceBeginningPosition, i)));
                    sentenceBeginningPosition = i;
                    sentenceEnd = false;
                }
                else if(sentenceEnd && (i < text.length()) && (text.charAt(i) == '„' || text.charAt(i) == '“')) i++;
                else if((text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!' || text.charAt(i) == '…')) {
                    sentenceEnd = true;
                }
                i++;
            }
        }
    }

    public void formLithuanianSymbolsList() {
        lithuanianSymbols.add('Ą');
        lithuanianSymbols.add('Č');
        lithuanianSymbols.add('Ę');
        lithuanianSymbols.add('Ė');
        lithuanianSymbols.add('Į');
        lithuanianSymbols.add('Š');
        lithuanianSymbols.add('Ų');
        lithuanianSymbols.add('Ū');
        lithuanianSymbols.add('Ž');
    }

}
