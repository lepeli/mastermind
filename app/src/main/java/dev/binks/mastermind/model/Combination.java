package dev.binks.mastermind.model;

import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Random;

import dev.binks.mastermind.R;
import dev.binks.mastermind.constants.ColorItem;

/**
 * A mastermind combination.
 */
public class Combination {

    protected ColorItem[] combination;

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

    public void fillWithRandomColorItems(boolean emptyCases) {

        this.combination = new ColorItem[4];
        ColorItem[] colorsWithEmpty = new ColorItem[] {ColorItem.DKGRAY, ColorItem.GREEN, ColorItem.RED, ColorItem.WHITE, ColorItem.BLACK, ColorItem.BLUE, ColorItem.YELLOW};
        ColorItem[] colorsWithoutEmpty = new ColorItem[] {ColorItem.GREEN, ColorItem.RED, ColorItem.WHITE, ColorItem.BLACK, ColorItem.BLUE, ColorItem.YELLOW};
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            if(emptyCases){
                this.combination[i] = colorsWithEmpty[rand.nextInt(colorsWithEmpty.length)];
            } else{
                this.combination[i] = colorsWithoutEmpty[rand.nextInt(colorsWithoutEmpty.length)];
            }
        }

        Log.v("Secret combination", "Random generation done");
    }

    /**
     * Compare the combination with the argument combination.
     * @param comparison
     * @return the result combination
     */
    public ResultCombination compareWith(Combination comparison) {
        ResultCombination result = new ResultCombination();
        for (int i = 0; i < this.combination.length; i++) {
            ColorItem firstVerifItem = getColor(i);
            ColorItem compItem = comparison.getColor(i);

            // mets un item noir si couleur bien placée
            if (firstVerifItem == compItem)
                result.setColor(ColorItem.BLACK, i);

            // sinon vérifie si la couleur est présente dans la combinaison
            // et mets un item blanc
            else {
                for (int j = 0; j < this.combination.length; j++) {
                    ColorItem secondVerifItem = getColor(j);
                    if (compItem == secondVerifItem) {
                        result.setColor(ColorItem.WHITE, i);
                    }
                }
            }
        }
        return result;
    }

    public int getLength() {
        return this.combination.length;
    }
}
