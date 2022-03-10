package com.example.wordle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.navigation.fragment.NavHostFragment;

public class GameFive extends Game{

    public GameFive() {
        fields = new TextView[6][5];
        size = 5;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflatePopUp(inflater);
        return inflater.inflate(R.layout.fragment_game_five, container, false);
    }

    protected void setFields () {
        super.setFields();
    }

    @Override
    protected void refresh() {
        NavHostFragment.findNavController(GameFive.this)
                .navigate(R.id.action_gameFive_self);
    }

    @Override
    protected void back() {
        NavHostFragment.findNavController(GameFive.this)
                .navigate(R.id.action_gameFive_to_mainFragment);
    }
}