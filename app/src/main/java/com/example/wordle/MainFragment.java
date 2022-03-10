package com.example.wordle;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainFragment extends Fragment implements View.OnClickListener{

    private View binding;

    public MainFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = view;
        binding.findViewById(R.id.button_5).setOnClickListener(this);
        binding.findViewById(R.id.button_6).setOnClickListener(this);
        binding.findViewById(R.id.button_9).setOnClickListener(this);
        binding.findViewById(R.id.button_in).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = (String) getResources().getResourceEntryName(view.getId());
        if (name.equals("button_5")) {
            NavHostFragment.findNavController(MainFragment.this)
                    .navigate(R.id.action_mainFragment_to_gameFive);
        }
        else if (name.equals("button_6")) {
            NavHostFragment.findNavController(MainFragment.this)
                    .navigate(R.id.action_mainFragment_to_gameSix);
        }
        else if (name.equals("button_9")) {
            NavHostFragment.findNavController(MainFragment.this)
                    .navigate(R.id.action_mainFragment_to_gameNine);
        }
        else if (name.equals("button_in")) {
            NavHostFragment.findNavController(MainFragment.this)
                    .navigate(R.id.action_mainFragment_to_instructionFragment);
        }
    }
}