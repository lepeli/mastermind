package dev.binks.mastermind;
import android.os.Bundle;
import android.preference.PreferenceActivity;
public class SettingsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.parametres);
    }
}
