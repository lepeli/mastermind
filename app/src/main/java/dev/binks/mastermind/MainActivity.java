package dev.binks.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import dev.binks.mastermind.activities.CombinationCreatorActivity;
import dev.binks.mastermind.activities.GameWindowActivity;
import dev.binks.mastermind.activities.SettingsActivity;
import dev.binks.mastermind.model.GameModel;
import dev.binks.mastermind.R;
import dev.binks.mastermind.view.MainMenuListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainMenuListener.setupMainMenuListeners(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.gotoparams){
            this.startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Display the correct display according to the gameMode
     * @param gameMode
     */
    public void displayGameView(String gameMode) {
        switch (gameMode) {
            case "solo":
                this.startActivity(new Intent(this, GameWindowActivity.class));
                break;
            case "duo":
                this.startActivity(new Intent(this, CombinationCreatorActivity.class));
                break;
        }
    }

}