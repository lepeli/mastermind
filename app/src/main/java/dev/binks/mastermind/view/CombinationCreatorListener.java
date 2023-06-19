package dev.binks.mastermind.view;

import android.view.View;

import dev.binks.mastermind.R;
import dev.binks.mastermind.activities.CombinationCreatorActivity;

public class CombinationCreatorListener implements View.OnClickListener {

    private CombinationCreatorActivity controller;


    public CombinationCreatorListener(CombinationCreatorActivity controller) {
        this.controller = controller;
    }

    /**
     * @param view
     */
    @Override
    public void onClick(View view) {
        InputCombinationView source = (InputCombinationView) this.controller.findViewById(R.id.gameInputView);
        // faire le check pour truc vide
        this.controller.setSecretCombination(source.getCombination());
    }

    public static void setupButtonListener(CombinationCreatorActivity controller) {
        controller.findViewById(R.id.startDuoGame2).setOnClickListener(new CombinationCreatorListener(controller));
    }
}
