package dev.binks.mastermind.view;

import android.view.DragEvent;
import android.view.View;

import dev.binks.mastermind.activities.GameWindowActivity;

public class InputCombinationDragListener implements View.OnDragListener{

    GameWindowActivity controller;
    public InputCombinationDragListener(GameWindowActivity controller) {
        this.controller = controller;
    }
    /**
     * @param view
     * @param dragEvent
     * @return
     */
    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        return true;
    }
}
