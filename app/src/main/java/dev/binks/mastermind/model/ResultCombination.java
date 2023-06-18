package dev.binks.mastermind.model;

import android.graphics.Color;

import dev.binks.mastermind.constants.ColorItem;

/**
 * Result combination class. Can determine a winning situation.
 */
public class ResultCombination extends Combination {

    public ResultCombination() {
        super();
        for (int i = 0; i < this.combination.length; i++)
            this.combination[i] = ColorItem.DKGRAY;
    }

    /**
     * Checks if the result is a winning result.
     * @return true if winning
     */
    public boolean isWinning() {
        int sum = 0;
        for (int i = 0; i < this.combination.length; i++)
            sum += this.combination[i] == ColorItem.BLACK ? 1 : 0;

        return sum == this.combination.length;
    }
}
