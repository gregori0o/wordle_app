package com.example.wordle;

public class Library {

    private final int length;

    public Library(int length) {
        this.length = length;
    }

    private void loadLibrary () {
        //load words of length to memory
    }

    public String getWord () {
        return "domek";
    }

    public Boolean checkWord (String word) {
        if (word.length() == this.length)
            return true;
        return false;
    }

}
