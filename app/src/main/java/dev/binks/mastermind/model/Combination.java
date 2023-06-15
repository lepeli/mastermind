package dev.binks.mastermind.model;

import android.util.Log;

import dev.binks.mastermind.constants.ColorItem;

/**
 * A mastermind combination.
 */
public class Combination {

    private ColorItem[] combination;

    /**
     * Constructor.
     */
    public Combination() {
        this.combination = new ColorItem[4];
    }

    /**
     * Constructor.
     * Directly set the passed combination.
     * @param combination
     */
    public Combination(ColorItem[] combination) {
        this.combination = combination;
    }

    /**
     * Get the color at the index
     *
     * @param index
     * @return the corresponding color
     */
    public ColorItem getColor(int index) {
        return this.combination[index];
    }

    /**
     * Set the color at the index
     *
     * @param color the chosen color
     * @param index
     * @throws IllegalArgumentException if wrong index
     */
    public void setColor(ColorItem color, int index) {
        try {
            if (index >= this.combination.length || index < 0)
                throw new IllegalArgumentException();

            this.combination[index] = color;

        } catch (IllegalArgumentException e) {
            Log.e(e.toString(), "Illegal index.");
        }
    }

    public void fillWithRandomColorItems() {
        //TODO: Algo pour générer combi
        // Placeholder :
        this.combination = new ColorItem[] {ColorItem.BLUE, ColorItem.CYAN, ColorItem.RED, ColorItem.MAGENTA};
        Log.v("Secret combination", "Random generation done");
    }
}
