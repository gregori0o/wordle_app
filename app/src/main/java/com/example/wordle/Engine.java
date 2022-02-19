package com.example.wordle;

import java.util.HashMap;

public class Engine {
    private Library library;
    private int[] line;
    private HashMap<Character, Integer> alphabet;
    private final String letters = "qwertyuiopasdfghjklzxcvbnmąćęłóśńżź";

    public Engine (int length) {
        library = new Library(length);
        line = new int[length];
        alphabet = new HashMap<>();
        for (char ch: letters.toCharArray()) {
            alphabet.put(ch, 0);
        }
    }

    public Boolean evaluateLine (String word) {
        if (!library.checkWord(word))
            return false;

        //do something


        return true;
    }

    public int[] getLine() {
        return line;
    }

    public HashMap<Character, Integer> getAlphabet() {
        return alphabet;
    }
}


