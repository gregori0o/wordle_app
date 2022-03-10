package com.example.wordle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.navigation.fragment.NavHostFragment;

public class GameNine extends Game{

    public GameNine() {
        fields = new TextView[7][9];
        size = 9;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflatePopUp(inflater);
        return inflater.inflate(R.layout.fragment_game_nine, container, false);
    }

    protected void setFields () {
        super.setFields();
        fields[0][5] = (TextView) binding.findViewById(R.id.text1_6);
        fields[0][6] = (TextView) binding.findViewById(R.id.text1_7);
        fields[0][7] = (TextView) binding.findViewById(R.id.text1_8);
        fields[0][8] = (TextView) binding.findViewById(R.id.text1_9);

        fields[1][5] = (TextView) binding.findViewById(R.id.text2_6);
        fields[1][6] = (TextView) binding.findViewById(R.id.text2_7);
        fields[1][7] = (TextView) binding.findViewById(R.id.text2_8);
        fields[1][8] = (TextView) binding.findViewById(R.id.text2_9);

        fields[2][5] = (TextView) binding.findViewById(R.id.text3_6);
        fields[2][6] = (TextView) binding.findViewById(R.id.text3_7);
        fields[2][7] = (TextView) binding.findViewById(R.id.text3_8);
        fields[2][8] = (TextView) binding.findViewById(R.id.text3_9);

        fields[3][5] = (TextView) binding.findViewById(R.id.text4_6);
        fields[3][6] = (TextView) binding.findViewById(R.id.text4_7);
        fields[3][7] = (TextView) binding.findViewById(R.id.text4_8);
        fields[3][8] = (TextView) binding.findViewById(R.id.text4_9);

        fields[4][5] = (TextView) binding.findViewById(R.id.text5_6);
        fields[4][6] = (TextView) binding.findViewById(R.id.text5_7);
        fields[4][7] = (TextView) binding.findViewById(R.id.text5_8);
        fields[4][8] = (TextView) binding.findViewById(R.id.text5_9);

        fields[5][5] = (TextView) binding.findViewById(R.id.text6_6);
        fields[5][6] = (TextView) binding.findViewById(R.id.text6_7);
        fields[5][7] = (TextView) binding.findViewById(R.id.text6_8);
        fields[5][8] = (TextView) binding.findViewById(R.id.text6_9);

        fields[6][0] = (TextView) binding.findViewById(R.id.text7_1);
        fields[6][1] = (TextView) binding.findViewById(R.id.text7_2);
        fields[6][2] = (TextView) binding.findViewById(R.id.text7_3);
        fields[6][3] = (TextView) binding.findViewById(R.id.text7_4);
        fields[6][4] = (TextView) binding.findViewById(R.id.text7_5);
        fields[6][5] = (TextView) binding.findViewById(R.id.text7_6);
        fields[6][6] = (TextView) binding.findViewById(R.id.text7_7);
        fields[6][7] = (TextView) binding.findViewById(R.id.text7_8);
        fields[6][8] = (TextView) binding.findViewById(R.id.text7_9);
    }

    @Override
    protected void refresh() {
        NavHostFragment.findNavController(GameNine.this)
                .navigate(R.id.action_gameNine_self);
    }

    @Override
    protected void back() {
        NavHostFragment.findNavController(GameNine.this)
                .navigate(R.id.action_gameNine_to_mainFragment);
    }
}