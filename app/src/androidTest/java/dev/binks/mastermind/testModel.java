package dev.binks.mastermind;

import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import dev.binks.mastermind.activities.GameWindowActivity;
import dev.binks.mastermind.constants.ColorItem;
import dev.binks.mastermind.model.Combination;
import dev.binks.mastermind.model.GameModel;

/**
 * Inutile de le tester sur le téléphone mais on va changer ce test
 */
@RunWith(AndroidJUnit4.class)
public class testModel {

    @Test
    public void testModel() {
        // generates a random secret combination
        GameModel gm = new GameModel(null);

        Combination test = new Combination(new ColorItem[] {
                ColorItem.BLUE,
                ColorItem.RED,
                ColorItem.GREEN,
                ColorItem.RED,
        });

        // supposed to return false right now
        boolean result = gm.testPlayerGuessCombination(test);
        assertEquals(result, false);
        // Log.v("Test result 1 :", String.valueOf(result));

        Combination test2 = new Combination(new ColorItem[] {
                ColorItem.BLUE,
                ColorItem.YELLOW,
                ColorItem.RED,
                ColorItem.GREEN,
        });

        // supposed to return true for now
        result = gm.testPlayerGuessCombination(test2);
        assertEquals(result, true);
        // Log.v("Test result 2 :", String.valueOf(result));
    }
}
