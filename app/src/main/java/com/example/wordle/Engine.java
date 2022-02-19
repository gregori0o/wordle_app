package com.example.wordle;

import java.util.HashMap;

public class Engine {
    private final int size;
    private Library library;
    private int[] line;
    private HashMap<Character, Integer> alphabet;
    private final String letters = "qwertyuiopasdfghjklzxcvbnmąćęłóśńżź";

    public Engine (int length) {
        library = new Library(length);
        line = new int[length];
        alphabet = new HashMap<Character, Integer>();
        for (Character ch: letters.toCharArray()) {
            alphabet.put(ch, 0);
        }
        size = length;
    }

    public Boolean evaluateLine (String word) {
        if (!library.checkWord(word))
            return false;
        char[] solution = library.getWord().toCharArray();
        char[] probe = word.toCharArray();
        boolean[] used = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (probe[i] == solution[i]) {
                line[i] = 3;
                used[i] = true;
            }
            else {
                line[i] = 0;
                used[i] = false;
            }
        }
        for (int i = 0; i < size; i++) {
            if (line[i] != 0) continue;
            for (int j = 0; j < size; j++) {
                if (used[j]) continue;
                if (probe[i] == solution[j]) {
                    line[i] = 2;
                    used[j] = true;
                    break;
                }
            }
            if (line[i] == 0)
                line[i] = 1;
        }
        for (int i = 0; i < size; i++) {
            char letter = probe[i];
            int value = line[i];
            if (value == 1) {
                if (alphabet.get(letter) == 0)
                    alphabet.put(letter, value);
            }
            else if (value == 2) {
                if (alphabet.get(letter) != 3)
                    alphabet.put(letter, value);
            }
            else if (value == 3) {
                alphabet.put(letter, value);
            }
        }
        return true;
    }

    public int[] getLine() {
        return line;
    }

    public HashMap<Character, Integer> getAlphabet() {
        return alphabet;
    }

    public boolean checkWin () {
        for(Integer val: line) {
            if (val != 3) return false;
        }
        return true;
    }
}


