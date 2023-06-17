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

    public ColorCircleView(Context context, ColorItem color) {
        super(context);

        this.paint = new Paint();
        this.paint.setColor(color.value);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100, 100, 100, this.paint);
    }
}
