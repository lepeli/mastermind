package dev.binks.mastermind.model;

/**
 * Le model du jeu, il contient tout ce qui concerne le fonctionnement du jeu
 */
public class GameModel {

    private Combination secretCombination;

    /**
     * Constructor.
     * Generates a secret combination.
     */
    public GameModel() {
        this.secretCombination = generateCombination();
    }

    /**
     * Constructor.
     * Use the player's input as secret combination.
     * @param secretCombination
     */
    public GameModel(Combination secretCombination) {
        this.secretCombination = secretCombination;
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
