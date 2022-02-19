package com.example.wordle;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.HashMap;


public class GameFive extends Fragment implements View.OnClickListener{

    private View binding;
    private TextView[][] fields = new TextView[6][5];
    private HashMap<String, Button> buttons = new HashMap();
    private int row = 0;
    private int column = 0;
    private Engine engine = new Engine(5);
    private View popupView;
    private PopupWindow popupError;

    public GameFive() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        popupView = inflater.inflate(R.layout.pop_up, null);
        return inflater.inflate(R.layout.fragment_game_five, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = view;

        binding.findViewById(R.id.enter).setOnClickListener(this);
        binding.findViewById(R.id.delete).setOnClickListener(this);

        setButtons();
        setFields();
        row = 0;
        column = 0;
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        boolean focusable = true;
        popupError = new PopupWindow(popupView, width, height, focusable);
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupError.dismiss();
                return true;
            }
        });
    }

    private void setButtons () {
        buttons.put("q", (Button) binding.findViewById(R.id.q));
        buttons.put("w", (Button) binding.findViewById(R.id.w));
        buttons.put("e", (Button) binding.findViewById(R.id.e));
        buttons.put("r", (Button) binding.findViewById(R.id.r));
        buttons.put("t", (Button) binding.findViewById(R.id.t));
        buttons.put("y", (Button) binding.findViewById(R.id.y));
        buttons.put("u", (Button) binding.findViewById(R.id.u));
        buttons.put("i", (Button) binding.findViewById(R.id.i));
        buttons.put("o", (Button) binding.findViewById(R.id.o));
        buttons.put("p", (Button) binding.findViewById(R.id.p));
        buttons.put("a", (Button) binding.findViewById(R.id.a));
        buttons.put("s", (Button) binding.findViewById(R.id.s));
        buttons.put("d", (Button) binding.findViewById(R.id.d));
        buttons.put("f", (Button) binding.findViewById(R.id.f));
        buttons.put("g", (Button) binding.findViewById(R.id.g));
        buttons.put("h", (Button) binding.findViewById(R.id.h));
        buttons.put("j", (Button) binding.findViewById(R.id.j));
        buttons.put("k", (Button) binding.findViewById(R.id.k));
        buttons.put("l", (Button) binding.findViewById(R.id.l));
        buttons.put("z", (Button) binding.findViewById(R.id.z));
        buttons.put("x", (Button) binding.findViewById(R.id.x));
        buttons.put("c", (Button) binding.findViewById(R.id.c));
        buttons.put("v", (Button) binding.findViewById(R.id.v));
        buttons.put("b", (Button) binding.findViewById(R.id.b));
        buttons.put("n", (Button) binding.findViewById(R.id.n));
        buttons.put("m", (Button) binding.findViewById(R.id.m));
        buttons.put("ą", (Button) binding.findViewById(R.id.ą));
        buttons.put("ć", (Button) binding.findViewById(R.id.ć));
        buttons.put("ę", (Button) binding.findViewById(R.id.ę));
        buttons.put("ł", (Button) binding.findViewById(R.id.ł));
        buttons.put("ó", (Button) binding.findViewById(R.id.ó));
        buttons.put("ś", (Button) binding.findViewById(R.id.ś));
        buttons.put("ń", (Button) binding.findViewById(R.id.ń));
        buttons.put("ż", (Button) binding.findViewById(R.id.ż));
        buttons.put("ź", (Button) binding.findViewById(R.id.ź));

        for (Button butt: buttons.values()) {
            butt.setOnClickListener(this);
        }

    }

    private void setFields () {
        fields[0][0] = (TextView) binding.findViewById(R.id.text1_1);
        fields[0][1] = (TextView) binding.findViewById(R.id.text1_2);
        fields[0][2] = (TextView) binding.findViewById(R.id.text1_3);
        fields[0][3] = (TextView) binding.findViewById(R.id.text1_4);
        fields[0][4] = (TextView) binding.findViewById(R.id.text1_5);

        fields[1][0] = (TextView) binding.findViewById(R.id.text2_1);
        fields[1][1] = (TextView) binding.findViewById(R.id.text2_2);
        fields[1][2] = (TextView) binding.findViewById(R.id.text2_3);
        fields[1][3] = (TextView) binding.findViewById(R.id.text2_4);
        fields[1][4] = (TextView) binding.findViewById(R.id.text2_5);

        fields[2][0] = (TextView) binding.findViewById(R.id.text3_1);
        fields[2][1] = (TextView) binding.findViewById(R.id.text3_2);
        fields[2][2] = (TextView) binding.findViewById(R.id.text3_3);
        fields[2][3] = (TextView) binding.findViewById(R.id.text3_4);
        fields[2][4] = (TextView) binding.findViewById(R.id.text3_5);

        fields[3][0] = (TextView) binding.findViewById(R.id.text4_1);
        fields[3][1] = (TextView) binding.findViewById(R.id.text4_2);
        fields[3][2] = (TextView) binding.findViewById(R.id.text4_3);
        fields[3][3] = (TextView) binding.findViewById(R.id.text4_4);
        fields[3][4] = (TextView) binding.findViewById(R.id.text4_5);

        fields[4][0] = (TextView) binding.findViewById(R.id.text5_1);
        fields[4][1] = (TextView) binding.findViewById(R.id.text5_2);
        fields[4][2] = (TextView) binding.findViewById(R.id.text5_3);
        fields[4][3] = (TextView) binding.findViewById(R.id.text5_4);
        fields[4][4] = (TextView) binding.findViewById(R.id.text5_5);

        fields[5][0] = (TextView) binding.findViewById(R.id.text6_1);
        fields[5][1] = (TextView) binding.findViewById(R.id.text6_2);
        fields[5][2] = (TextView) binding.findViewById(R.id.text6_3);
        fields[5][3] = (TextView) binding.findViewById(R.id.text6_4);
        fields[5][4] = (TextView) binding.findViewById(R.id.text6_5);
    }

    @Override
    public void onClick(View view) {
        String name = (String) getResources().getResourceEntryName(view.getId());
        if (name.equals("enter")) {
            if (row < 6 && column == 5) {
                String word = "";
                for (int i = 0; i < 5; i++)
                    word += fields[column][i].getText().toString();
                if (engine.evaluateLine(word)) {
                    int[] line = engine.getLine();
                    HashMap map = engine.getAlphabet();
                    markLine (line);
                    markLetters (map);
                    column += 1;
                    row = 0;
                }
                else {
                    popupError.showAtLocation(binding, Gravity.TOP, 0, 0);
                }
            }
        }
        else if (name.equals("delete")) {
            if (row < 6 && column > 0) {
                column -= 1;
                fields[row][column].setText("");
            }
        }
        else {
            if (row < 6 && column < 5) {
                fields[row][column].setText(name.toUpperCase());
                column += 1;
            }
        }
    }

    private void markLetters(HashMap map) {
        //to do
    }

    private void markLine(int[] line) {
        //do it
    }
}