package dev.binks.mastermind.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import dev.binks.mastermind.R;
import dev.binks.mastermind.constants.ColorItem;
import dev.binks.mastermind.model.Combination;
import dev.binks.mastermind.model.GameModel;
import dev.binks.mastermind.model.ResultCombination;
import dev.binks.mastermind.view.GameButtonViewListener;
import dev.binks.mastermind.view.GameGridView;
import dev.binks.mastermind.view.InputCombinationListener;
import dev.binks.mastermind.view.InputCombinationView;

public class GameWindowActivity extends AppCompatActivity {

    private GameModel gameModel;
    private GameGridView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_game_window);
        super.onCreate(savedInstanceState);

        this.view = findViewById(R.id.gameView);

        // if the hotseat mode, pass the user input as secret code
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int[] secretCode = extras.getIntArray("colors");
            ColorItem[] colorItems = new ColorItem[4];

            for (int i = 0; i < secretCode.length; i++)
                colorItems[i] = new ColorItem(secretCode[i]);

            Combination combination = new Combination(colorItems);
            this.gameModel = new GameModel(this, combination);

        } else {
            this.gameModel = new GameModel(this);
        }

        InputCombinationListener.setupInputListeners(this);
        GameButtonViewListener.setupButtonListener(this);

    // only for test purpose
//        this.gameModel.testPlayerGuessCombination(new Combination(new ColorItem[] {
//                ColorItem.BLUE,
//                ColorItem.BLACK,
//                ColorItem.YELLOW,
//                ColorItem.RED
//        }));
}

    /**
     * Process the user's guess input.
     *
     * @param input user input
     * @return true if the combination is a winning combination
     */
    public boolean submitPlayerInput(Combination input) {
        return this.gameModel.testPlayerGuessCombination(input);
    }

    /**
     * Display the result combination as a feedback to the player's guess.
     *
     * @param result the result
     */
    public void displayInputFeedback(Combination input, ResultCombination result, int index) {
        this.view.displayCombination(input, index);
        this.view.displayResult(result, index);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.v("Save", "Saving instance");
        super.onSaveInstanceState(outState);
        this.gameModel.saveGameData(outState);

        InputCombinationView inputView = (InputCombinationView) this.findViewById(R.id.gameInputView);
        Combination input = inputView.getCombination();
        int[] inputColors = new int[input.getLength()];

        for (int i = 0; i < input.getLength(); i++) {
            inputColors[i] = input.getColor(i).value;
        }

        outState.putIntArray("input_colors", inputColors);

        Log.v("Save", "Activity saved !");
    }

    public void onRestoreInstanceState(Bundle inState){
        Log.v("Save", "Restoring instance");
        this.gameModel.restoreGameData(inState);

        InputCombinationView inputCombinationView = (InputCombinationView) this.findViewById(R.id.gameInputView);

        Combination combination = new Combination();
        int[] inputColors = inState.getIntArray("input_colors");

        for (int i = 0; i < inputColors.length; i++) {
            combination.setColor(new ColorItem(inputColors[i]), i);
        }

        inputCombinationView.setCombination(combination);

        Log.v("Save", "Instance restored ! ");
    }
}