package dev.binks.mastermind.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import dev.binks.mastermind.R;
import dev.binks.mastermind.model.Combination;
import dev.binks.mastermind.model.GameModel;
import dev.binks.mastermind.model.ResultCombination;

public class GameWindowActivity extends AppCompatActivity {

    private GameModel gameModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_game_window);
        super.onCreate(savedInstanceState);

        //TODO: passer un bundle avec la combinaison du joueur si c en hotseat
        // if (y'a une combinaison passée)
        // this.gameModel = new GameModel(this, combination);

        this.gameModel = new GameModel(this);
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
    public void displayInputFeedback(ResultCombination result) {
        // this.view.displayResult(result);
    }
}