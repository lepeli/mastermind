package dev.binks.mastermind.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.GravityInt;
import androidx.annotation.Nullable;

import dev.binks.mastermind.R;
import dev.binks.mastermind.constants.ColorItem;
import dev.binks.mastermind.model.Combination;
import dev.binks.mastermind.model.ResultCombination;

/**
 * The game grid view.
 */
public class GameGridView extends TableLayout {

    private final int WIDTH = 4;
    private final int HEIGHT = 10;
    private final int LAYOUT_COMBI_SIZE = 130;
    private final int LAYOUT_RESULT_SIZE = 65;

    public GameGridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(getResources().getColor(androidx.cardview.R.color.cardview_dark_background));

        // Create the grid

        for (int i = 0; i < this.HEIGHT; i++) {
            TableRow tr = new TableRow(context);
            tr.setGravity(Gravity.BOTTOM);
            for (int j = 0; j < this.WIDTH; j++) {
                ColorCircleView circle = new ColorCircleView(context, ColorItem.DKGRAY, false);
                tr.addView(circle, new TableRow.LayoutParams(LAYOUT_COMBI_SIZE, LAYOUT_COMBI_SIZE));
            }
            this.addView(tr);
        }
    }

    public void displayCombination(Combination combination, int index) {
        TableRow tr = (TableRow) getChildAt(index);
        tr.removeAllViewsInLayout();

        for (int i = 0; i < combination.getLength(); i++) {
            tr.addView(new ColorCircleView(this.getContext(), combination.getColor(i), false), new TableRow.LayoutParams(LAYOUT_COMBI_SIZE, LAYOUT_COMBI_SIZE));
        }

        tr.invalidate();
    }

    public void displayResult(ResultCombination result, int index) {
        TableRow tr = (TableRow) getChildAt(index);

        for (int i = 0; i < result.getLength(); i++) {
            tr.addView(new ColorCircleView(this.getContext(), result.getColor(i), true), new TableRow.LayoutParams(LAYOUT_RESULT_SIZE, LAYOUT_RESULT_SIZE));
        }

        invalidate();
    }
}
