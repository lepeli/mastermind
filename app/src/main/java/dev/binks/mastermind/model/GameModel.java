package dev.binks.mastermind.model;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;

import dev.binks.mastermind.R;
import dev.binks.mastermind.activities.GameWindowActivity;
import dev.binks.mastermind.constants.ColorItem;

/**
 * Le model du jeu, il contient tout ce qui concerne le fonctionnement du jeu
 */
public class GameModel {

    private Combination secretCombination;
    private GameWindowActivity controller;
    private SharedPreferences prefs;
    private int nTry;

    private Combination[] tries;

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
        this.tries = new Combination[10];
    }

    /**
     * Constructor.
     * Use the player's input as secret combination.
     * @param secretCombination
     */
    public GameModel(GameWindowActivity controller, Combination secretCombination) {
        this(controller);
        this.secretCombination = secretCombination;
    }

    /**
     * Test the guess combination entered by the player
     * @param combination player's input
     * @return true if the player won
     */
    public boolean testPlayerGuessCombination(Combination combination) {
        // TODO: Ajouter un check pour vérifier que l'on a pas dépassé le nombre d'essais possibles.
        // IF NTRY == 9: alors arrêter
        ResultCombination result = this.secretCombination.compareWith(combination);
        this.controller.displayInputFeedback(combination, result, this.nTry);

        this.tries[this.nTry] = combination;
        this.nTry++;

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

        combination.fillWithRandomColorItems(this.prefs.getBoolean("void_cases_enabled", false));

        return combination;
    }

    /**
     * Saves game data
     * @param bundleOut bundle in which to save the game model data
     */
    public void saveGameData(Bundle bundleOut){
        Log.v("Game Save", "Saving game data");
        // Save the secretCombination
        int[] secretColors = new int[secretCombination.getLength()];

        for (int i = 0; i < secretCombination.getLength(); i++) {
            secretColors[i] = secretCombination.getColor(i).value;
        }

        bundleOut.putIntArray("secret_key", secretColors);
        bundleOut.putInt("nTry", this.nTry);

        for (int i = 0; i < this.nTry; i++) {
            Combination comb = this.tries[i];
            int[] combColors = new int[comb.getLength()];
            for (int j = 0; j < comb.getLength(); j++) {
                combColors[j] = comb.getColor(j).value;
            }
            bundleOut.putIntArray("tried_comb_" + String.valueOf(i), combColors);
        }

        Log.v("Game Save", "Game data save done !");
    }

    /**
     * Restores the game data from a bundle
     * @param bundleIn bundle from which to get Data
     */
    public void restoreGameData(Bundle bundleIn){
        Log.v("Game Save", "Saving game data");
        this.secretCombination = new Combination();
        int[] secretColors = bundleIn.getIntArray("secret_key");
        for (int i = 0; i < secretColors.length; i++) {
            this.secretCombination.setColor(new ColorItem(secretColors[i]), i);
        }

        this.nTry = bundleIn.getInt("nTry");

        for (int i = 0; i < this.nTry; i++) {
            int[] combColors = bundleIn.getIntArray("tried_comb_" + String.valueOf(i));
            Combination combination = new Combination();
            for (int j = 0; j < combColors.length; j++) {
                combination.setColor(new ColorItem(combColors[j]), j);
            }
            this.tries[i] = combination;
            ResultCombination result = this.secretCombination.compareWith(combination);
            this.controller.displayInputFeedback(combination, result, i);
        }

        Log.v("Game Save", "Restoration complete ! :dab:");
    }
}
