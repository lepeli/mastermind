package dev.binks.mastermind.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import dev.binks.mastermind.constants.ColorItem;
import dev.binks.mastermind.model.Combination;

public class InputCombinationView extends LinearLayout {

    public InputCombinationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        for (int i = 0; i < 4; i++) {
            ColorCircleView inputCircle = new ColorCircleView(context, ColorItem.DKGRAY, false);
            this.addView(inputCircle, new LinearLayout.LayoutParams(130, 130));
        }
    }

    public Combination getCombination() {
        ColorItem[] colors = new ColorItem[4];

        for (int i = 0; i < this.getChildCount(); i++) {
            ColorCircleView circle = (ColorCircleView) this.getChildAt(i);
            colors[i] = circle.getColor();
        }

        return new Combination(colors);
    }
}
