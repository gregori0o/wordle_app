package com.example.wordle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.navigation.fragment.NavHostFragment;

public class GameSix extends Game{

    public GameSix() {
        fields = new TextView[6][6];
        size = 6;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflatePopUp(inflater);
        return inflater.inflate(R.layout.fragment_game_six, container, false);
    }

    protected void setFields () {
        super.setFields();

        fields[0][5] = (TextView) binding.findViewById(R.id.text1_6);
        fields[1][5] = (TextView) binding.findViewById(R.id.text2_6);
        fields[2][5] = (TextView) binding.findViewById(R.id.text3_6);
        fields[3][5] = (TextView) binding.findViewById(R.id.text4_6);
        fields[4][5] = (TextView) binding.findViewById(R.id.text5_6);
        fields[5][5] = (TextView) binding.findViewById(R.id.text6_6);
    }

    @Override
    protected void refresh() {
        NavHostFragment.findNavController(GameSix.this)
                .navigate(R.id.action_gameSix_self);
    }

    @Override
    protected void back() {
        NavHostFragment.findNavController(GameSix.this)
                .navigate(R.id.action_gameSix_to_mainFragment);
    }
}