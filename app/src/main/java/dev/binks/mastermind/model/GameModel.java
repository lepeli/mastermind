package dev.binks.mastermind.model;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import dev.binks.mastermind.R;
import dev.binks.mastermind.activities.GameWindowActivity;

/**
 * Le model du jeu, il contient tout ce qui concerne le fonctionnement du jeu
 */
public class GameModel {

    private Combination secretCombination;
    private GameWindowActivity controller;
    private SharedPreferences prefs;
    private int nTry;

    /**
     * Constructor.
     * Generates a secret combination.
     */
    public GameModel(GameWindowActivity controller) {
        PreferenceManager.setDefaultValues(controller, R.xml.parametres, false);
        this.prefs = PreferenceManager.getDefaultSharedPreferences(controller);
        this.secretCombination = generateCombination();
        this.controller = controller;
        this.nTry = 0;
    }

    /**
     * Constructor.
     * Use the player's input as secret combination.
     * @param secretCombination
     */
    public GameModel(GameWindowActivity controller, Combination secretCombination) {
        this.secretCombination = secretCombination;
    }

    /**
     * Test the guess combination entered by the player
     * @param combination player's input
     * @return true if the player won
     */
    public boolean testPlayerGuessCombination(Combination combination) {
        ResultCombination result = this.secretCombination.compareWith(combination);

        this.controller.displayInputFeedback(combination, result, this.nTry);

        if (result.isWinning()) {
            return true;
        }
        return false;
    }

    /**
     * Generates a random combination.
     * @return the generated combination
     */
    private Combination generateCombination() {
        Combination combination = new Combination();
        Log.v("Game settings", String.valueOf(this.prefs.getBoolean("void_cases_enabled", false)));

        combination.fillWithRandomColorItems(this.prefs.getBoolean("void_cases_enabled", false));

        return combination;
    }
}
