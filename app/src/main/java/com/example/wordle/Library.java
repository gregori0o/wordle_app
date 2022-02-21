package com.example.wordle;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Library {

    private final int length;
    private String word;
    private Set<String> full_lib = new HashSet<String>();
    private ArrayList<String> plain_lib = new ArrayList<String>();
    private Context context;

    public Library(Context c, int length) {
        this.length = length;
        this.context = c;
        loadLibrary();
        this.word = chooseWord();
    }

    private void loadLibrary () {
        BufferedReader bfr = null;
        String line = "";
        try {
            bfr = new BufferedReader(new InputStreamReader(context.getAssets().open("plain_" + length + ".txt")));
            while ((line = bfr.readLine()) != null) {
                plain_lib.add(line.substring(0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }

        bfr = null;
        try {
            bfr = new BufferedReader(new InputStreamReader(context.getAssets().open("full_" + length + ".txt")));
            while ((line = bfr.readLine()) != null) {
                full_lib.add(line.substring(0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }
    }

    private String chooseWord() {
        Random random = new Random();
        int index = random.nextInt(plain_lib.size());
        return plain_lib.get(index);
    }

    public String getWord () {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Boolean checkWord (String word) {
        return full_lib.contains(word);
    }

}
