package dev.binks.mastermind.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dev.binks.mastermind.R;
import dev.binks.mastermind.view.InputCombinationListener;
import dev.binks.mastermind.view.InputCombinationView;

public class CombinationCreatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination_creator);
        InputCombinationListener.setupInputListeners(this);
    }
}