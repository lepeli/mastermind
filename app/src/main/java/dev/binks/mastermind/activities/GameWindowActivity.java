package dev.binks.mastermind.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import dev.binks.mastermind.R;
import dev.binks.mastermind.constants.ColorItem;
import dev.binks.mastermind.model.Combination;
import dev.binks.mastermind.model.GameModel;
import dev.binks.mastermind.model.ResultCombination;
import dev.binks.mastermind.view.GameGridView;

public class GameWindowActivity extends AppCompatActivity {

    private GameModel gameModel;
    private GameGridView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_game_window);
        super.onCreate(savedInstanceState);

        //TODO: passer un bundle avec la combinaison du joueur si c en hotseat
        // if (y'a une combinaison passée)
        // this.gameModel = new GameModel(this, combination);

        this.gameModel = new GameModel(this);
        this.view = findViewById(R.id.gameView);

        // only for test purpose
        this.gameModel.testPlayerGuessCombination(new Combination(new ColorItem[] {
                ColorItem.BLUE,
                ColorItem.BLACK,
                ColorItem.GREEN,
                ColorItem.RED,
        }));
    }

    /**
     * Process the user's guess input.
     * @param input user input
     * @return true if the combination is a winning combination
     */
    public boolean submitPlayerInput(Combination input) {
        return this.gameModel.testPlayerGuessCombination(input);
    }

    /**
     * Display the result combination as a feedback to the player's guess.
     * @param result the result
     */
    public void displayInputFeedback(Combination input, ResultCombination result, int index) {
        this.view.displayCombination(input, index);
        // this.view.displayResult(result);
    }
}