package dev.binks.mastermind.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import dev.binks.mastermind.R;
import dev.binks.mastermind.constants.ColorItem;
import dev.binks.mastermind.model.Combination;
import dev.binks.mastermind.view.CombinationCreatorListener;
import dev.binks.mastermind.view.InputCombinationListener;
import dev.binks.mastermind.view.InputCombinationView;

public class CombinationCreatorActivity extends AppCompatActivity {

    private Boolean emptyCasesAllowed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination_creator);
        InputCombinationListener.setupInputListeners(this);
        CombinationCreatorListener.setupButtonListener(this);

        PreferenceManager.setDefaultValues(this, R.xml.parametres, false);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        this.emptyCasesAllowed = prefs.getBoolean("void_cases_enabled", false);

    }

    public void setSecretCombination(Combination combination) {

        if(!combination.isCombinationPossible(this.emptyCasesAllowed)){
            Toast.makeText(this, "Vous ne pouvez pas choisir une combinaison avec une case vide !", Toast.LENGTH_SHORT).show();
        } else {

            int[] colors = new int[4];

            for (int i = 0; i < combination.getLength(); i++) {
                colors[i] = combination.getColor(i).value;
            }

            Intent intent = new Intent(this, GameWindowActivity.class);
            intent.putExtra("colors", colors);

            this.startActivity(intent);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.v("Save", "Sauvegarde activité selection code secret");
        InputCombinationView combView = (InputCombinationView) this.findViewById(R.id.gameInputView);
        Combination combination = combView.getCombination();
        int[] colors = new int[4];
        for (int i = 0; i < combination.getLength(); i++) {
            colors[i] = combination.getColor(i).value;
        }
        outState.putIntArray("secret_code", colors);
        super.onSaveInstanceState(outState);
    }

    /**
     * Restore CombinationCreator
     * @param inState the data most recently supplied in {@link #onSaveInstanceState}.
     */
    public void onRestoreInstanceState(Bundle inState){
        Log.v("Save", "Restore in progress");
        int[] colors = inState.getIntArray("secret_code");
        InputCombinationView combView = (InputCombinationView) this.findViewById(R.id.gameInputView);
        Combination combination = new Combination();
        for (int i = 0; i < colors.length; i++) {
                  combination.setColor(new ColorItem(colors[i]), i);
        }
        combView.setCombination(combination);

    }
}