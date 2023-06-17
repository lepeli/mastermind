package dev.binks.mastermind.model;

import dev.binks.mastermind.activities.GameWindowActivity;

/**
 * Le model du jeu, il contient tout ce qui concerne le fonctionnement du jeu
 */
public class GameModel {

    private Combination secretCombination;
    private GameWindowActivity controller;

    /**
     * Constructor.
     * Generates a secret combination.
     */
    public GameModel(GameWindowActivity controller) {
        this.secretCombination = generateCombination();
        this.controller = controller;
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

        if (result.isWinning())
            return true;

        this.controller.displayInputFeedback(result);
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
