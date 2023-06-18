package dev.binks.mastermind.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import dev.binks.mastermind.constants.ColorItem;

/**
 * A circle of the game gird.
 */
public class ColorCircleView extends View {

    private Paint paint;
    private int size;
    private ColorItem color;

    public ColorCircleView(Context context, ColorItem color, boolean isResult) {
        super(context);

        if (isResult)
            this.size = 30;
        else
            this.size = 60;

        this.paint = new Paint();
        this.paint.setColor(color.value);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.size, this.size, this.size, this.paint);
    }

    public void setColor(ColorItem color) {
        this.color = color;
        this.paint.setColor(color.value);
        invalidate();
    }

    public ColorItem getColor() {
        return this.color;
    }
}
