package com.example.wordle;

public class Library {

    private final int length;
    private final String word;

    public Library(int length) {
        this.length = length;
        loadLibrary();
        this.word = chooseWord();
    }

    private void loadLibrary () {
        //load words of length to memory
    }

    private String chooseWord() {
        return "domek";
    }

    public String getWord () {
        return word;
    }

    public Boolean checkWord (String word) {
        if (word.length() == this.length)
            return true;
        return false;
    }

}
