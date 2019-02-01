package com.example.vailveix.scorekeeper;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;

    private TextView score1_text;
    private TextView score2_text;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt(STATE_SCORE_1, score1);
        outState.putInt(STATE_SCORE_2, score2);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score1_text = (TextView) findViewById(R.id.score_1);
        score2_text = (TextView) findViewById(R.id.score_2);

        if(savedInstanceState != null){
            score1 = savedInstanceState.getInt(STATE_SCORE_1);
            score2 = savedInstanceState.getInt(STATE_SCORE_2);

            score1_text.setText(String.valueOf(score1));
            score2_text.setText(String.valueOf(score2));
        }
    }

    public void decreaseScore(View view){
        int viewID = view.getId();

        switch (viewID){
            case R.id.decreaseTeam1:
                score1 --;
                score1_text.setText(String.valueOf(score1));
                break;
            case R.id.decreaseTeam2:
                score2 --;
                score2_text.setText(String.valueOf(score2));
        }
    }

    public void increaseScore(View view){
        int viewID = view.getId();

        switch (viewID){
            case R.id.increaseTeam1:
                score1 ++;
                score1_text.setText(String.valueOf(score1));
                break;
            case R.id.increaseTeam2:
                score2 ++;
                score2_text.setText(String.valueOf(score2));
        }
    }
}
