package dev.binks.mastermind.model;

import dev.binks.mastermind.activities.GameWindowActivity;

/**
 * Le model du jeu, il contient tout ce qui concerne le fonctionnement du jeu
 */
public class GameModel {

    private Combination secretCombination;
    private GameWindowActivity controller;
    private int nTry;

    /**
     * Constructor.
     * Generates a secret combination.
     */
    public GameModel(GameWindowActivity controller) {
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
        combination.fillWithRandomColorItems();

        return combination;
    }
}
