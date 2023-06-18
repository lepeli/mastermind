package dev.binks.mastermind.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
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

        // if the hotseat mode, pass the user input as secret code
        int[] secretCode = getIntent().getExtras().getIntArray("colors");
        if (secretCode.length >= 0) {
            ColorItem[] colorItems = new ColorItem[4];

            for (int i = 0; i < secretCode.length; i++)
                colorItems[i] = new ColorItem(secretCode[i]);

            Combination combination = new Combination(colorItems);
            this.gameModel = new GameModel(this, combination);
        } else {
            this.gameModel = new GameModel(this);
        }

        this.view = findViewById(R.id.gameView);
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
}