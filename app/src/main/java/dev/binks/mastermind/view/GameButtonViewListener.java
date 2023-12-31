package dev.binks.mastermind.view;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import dev.binks.mastermind.R;
import dev.binks.mastermind.activities.GameWindowActivity;
import dev.binks.mastermind.model.Combination;

public class GameButtonViewListener implements View.OnClickListener {

    GameWindowActivity controller;
    private SharedPreferences prefs;
    private boolean emptyCasesAllowed;
    public GameButtonViewListener(GameWindowActivity controller) {
        PreferenceManager.setDefaultValues(controller, R.xml.parametres, false);
        this.prefs = PreferenceManager.getDefaultSharedPreferences(controller);
        this.controller = controller;
        this.emptyCasesAllowed = this.prefs.getBoolean("void_cases_enabled", false);
    }

    /**
     * Method to listen to click on the input submit button
     * @param view the view in which the event occured
     */
    @Override
    public void onClick(View view) {
        InputCombinationView source = (InputCombinationView) controller.findViewById(R.id.gameInputView);
        Combination input = source.getCombination();

        if(!input.isCombinationPossible(this.emptyCasesAllowed)) {
            Toast.makeText(controller, "Vous ne pouvez pas mettre de case vide !", Toast.LENGTH_SHORT).show();
        } else {
            this.controller.submitPlayerInput(input);
        }

    }

    /**
     * Method to setup the button listener
     * @param controller the game controller
     */
    public static void setupButtonListener(GameWindowActivity controller) {
        controller.findViewById(R.id.submitInput).setOnClickListener(new GameButtonViewListener(controller));
    }
}
