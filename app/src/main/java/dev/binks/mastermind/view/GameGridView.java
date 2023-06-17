package dev.binks.mastermind.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

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

    public GameGridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // Create the grid

        for (int i = 0; i < this.HEIGHT; i++) {
            TableRow tr = new TableRow(context);
            for (int j = 0; j < this.WIDTH; j++) {
                ColorCircleView circle = new ColorCircleView(context, ColorItem.DKGRAY);
                tr.addView(circle, new TableRow.LayoutParams(210, 210));
            }
            this.addView(tr);
        }
    }

    public void displayCombination(Combination combination, int index) {
        TableRow tr = (TableRow) getChildAt(index);
        tr.removeAllViewsInLayout();

        for (int i = 0; i < combination.getLength(); i++) {
            tr.addView(new ColorCircleView(this.getContext(), combination.getColor(i)), new TableRow.LayoutParams(210, 210));
        }

        tr.invalidate();
    }

    public void displayResult(ResultCombination result, int index) {
        TableRow tr = (TableRow) getChildAt(index);
        tr.removeAllViews();

        for (int i = 0; i < result.getLength(); i++) {
            tr.addView(new ColorCircleView(this.getContext(), result.getColor(i)), new TableRow.LayoutParams(210, 210));
        }

        invalidate();
    }
}
