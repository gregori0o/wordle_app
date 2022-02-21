package com.example.wordle;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Engine {
    private final int size;
    private Library library;
    private int[] line;
    private HashMap<Character, Integer> alphabet;
    private final String letters = "qwertyuiopasdfghjklzxcvbnmąćęłóśńżź";

    private boolean is_saved;
    private int num_line = 1;
    private String[] lines;

    private File file;

    public Engine (Context c, int length) {
        library = new Library(c, length);
        line = new int[length];
        alphabet = new HashMap<Character, Integer>();
        for (Character ch: letters.toCharArray()) {
            alphabet.put(ch, 0);
        }
        size = length;

        file = new File (c.getFilesDir(), "save_" + length + ".txt");
        try {
            is_saved = ! file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        loadFromFile();
    }

    private void loadFromFile () {
        if (! is_saved) {
            try {
                FileOutputStream writer = new FileOutputStream(file);
                writer.write((library.getWord() + '\n').getBytes());
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
            return;
        }
        byte[] content = new byte[(int) file.length()];
        try {
            FileInputStream stream = new FileInputStream(file);
            stream.read(content);
            lines = new String(content).split("\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        if (lines.length == 1)
            is_saved = false;
        else
            library.setWord(lines[0]);
    }

    public boolean isLine () {
        return is_saved && num_line < lines.length;
    }

    public String getLineWord () {
        evaluateLine(lines[num_line]);
        return lines[num_line++];
    }

    private void saveWord (String word) {
        try {
            FileOutputStream writer = new FileOutputStream(file, true);
            writer.write((word + '\n').getBytes());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public boolean loadWord (String word) {
        if (!library.checkWord(word))
            return false;
        saveWord(word);
        evaluateLine(word);
        return true;
    }

    private void evaluateLine (String word) {
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

    public void endGame () {
        file.delete();
    }
}


