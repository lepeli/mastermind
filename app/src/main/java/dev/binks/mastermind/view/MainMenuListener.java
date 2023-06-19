package dev.binks.mastermind.view;

import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import dev.binks.mastermind.MainActivity;
import dev.binks.mastermind.R;

/**
 * Menu principal de l'application
 */
public class MainMenuListener implements View.OnClickListener {

    private MainActivity controller;

    public MainMenuListener(MainActivity controller) {
        this.controller = controller;
    }

    /**
     * Listener to get the gamemode selected by the player
     * @param view The view that was clicked.
     */
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.playSoloButton) {
            this.controller.displayGameView("solo");
        }
        else if (id == R.id.playDuoButton) {
            this.controller.displayGameView("duo");
        }
    }

    /**
     * Setup the main activity's buttons listeners.
     * @param app Main activity
     */
    public static void setupMainMenuListeners(MainActivity app) {
        app.findViewById(R.id.playSoloButton).setOnClickListener(new MainMenuListener(app));
        app.findViewById(R.id.playDuoButton).setOnClickListener(new MainMenuListener(app));
    }
}
