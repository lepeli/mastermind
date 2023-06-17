package dev.binks.mastermind.constants;

import android.graphics.Color;

/**
 * Class containing the game colors to avoid treating them as int.
 */
public class ColorItem {
    public static final ColorItem BLUE = new ColorItem(Color.BLUE);
    public static final ColorItem RED = new ColorItem(Color.RED);
    public static final ColorItem YELLOW = new ColorItem(Color.YELLOW);
    public static final ColorItem GREEN = new ColorItem(Color.GREEN);
    public static final ColorItem WHITE = new ColorItem(Color.WHITE);
    public static final ColorItem BLACK = new ColorItem(Color.BLACK);
    public static final ColorItem DKGRAY = new ColorItem(Color.DKGRAY);

    public int value;
    public ColorItem(int value) {
        this.value = value;
    }
}
