package dev.binks.mastermind.view;

import android.view.View;

import dev.binks.mastermind.R;
import dev.binks.mastermind.activities.GameWindowActivity;
import dev.binks.mastermind.model.Combination;

public class GameButtonViewListener implements View.OnClickListener {

    GameWindowActivity controller;

    public GameButtonViewListener(GameWindowActivity controller) {
        this.controller = controller;
    }

    /**
     * @param view
     */
    @Override
    public void onClick(View view) {
        InputCombinationView source = (InputCombinationView) controller.findViewById(R.id.gameInputView);
        Combination input = source.getCombination();

        this.controller.submitPlayerInput(input);
    }

    public static void setupButtonListener(GameWindowActivity controller) {
        controller.findViewById(R.id.submitInput).setOnClickListener(new GameButtonViewListener(controller));
    }
}
