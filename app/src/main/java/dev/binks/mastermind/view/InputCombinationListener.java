package dev.binks.mastermind.view;

import static android.content.Context.VIBRATOR_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.app.AlarmManager;
import android.content.Context;
import android.graphics.Camera;
import android.hardware.camera2.CameraCaptureSession;
import android.os.Vibrator;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import dev.binks.mastermind.R;
import dev.binks.mastermind.activities.GameWindowActivity;
import dev.binks.mastermind.constants.ColorItem;

public class InputCombinationListener implements View.OnTouchListener {

    /**
     * @param view
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float y = motionEvent.getY(0);
        Vibrator vibrator = (Vibrator) view.getContext().getSystemService(Context.VIBRATOR_SERVICE);
        ColorCircleView source = (ColorCircleView) view;

        if (y >= 0f) {
            source.setColor(ColorItem.DKGRAY);
        }
        else if (y <= -100f && y >= -200f) {
            source.setColor(ColorItem.BLUE);
            vibrator.vibrate(10);
        }
        else if (y <= -200f && y >= -300) {
            source.setColor(ColorItem.RED);

        }
        else if (y <= -300f && y >= -400f) {
            source.setColor(ColorItem.YELLOW);
            vibrator.vibrate(10);
        }
        else if (y <= -400f && y >= -500f) {
            source.setColor(ColorItem.GREEN);

        }
        else if (y <= -500f && y >= -600f) {
            source.setColor(ColorItem.WHITE);
            vibrator.vibrate(10);
        }
        else if (y <= -600f && y >= -700f) {
            source.setColor(ColorItem.BLACK);

        }

        return true;
    }
    public static void setupInputListeners(AppCompatActivity controller) {
        InputCombinationView view = controller.findViewById(R.id.gameInputView);
        int nChildren = view.getChildCount();
        for (int i = 0; i < nChildren; i++) {
            view.getChildAt(i).setOnTouchListener(new InputCombinationListener());
        }
    }
}
