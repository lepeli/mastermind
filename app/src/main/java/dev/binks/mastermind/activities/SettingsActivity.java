package dev.binks.mastermind.activities;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import dev.binks.mastermind.R;

public class SettingsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.parametres);
    }
}
