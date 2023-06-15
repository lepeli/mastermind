package dev.binks.mastermind.constants;

import android.graphics.Color;

/**
 * Class containing the game colors to avoid treating them as int.
 */
public class ColorItem {
    public static ColorItem BLUE = new ColorItem(Color.BLUE);
    public static ColorItem RED = new ColorItem(Color.RED);
    public static ColorItem CYAN = new ColorItem(Color.CYAN);
    public static ColorItem MAGENTA = new ColorItem(Color.MAGENTA);

    public int value;
    public ColorItem(int value) {
        this.value = value;
    }
}
