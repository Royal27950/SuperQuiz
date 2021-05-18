package com.example.superquiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.ConfigurationCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class Ranking extends AppCompatActivity {

    /*private static final int REQUEST_CODE_QUIZ=1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private int highScore;*/

    Spinner listCategory;
    String[] spinnerOptions = {"Histoire", "Géographie", "L'Attaque des Titans", "Pokémon", "Tokyo Ghoul", "My Hero Academia",
            "One Piece","Devine le logo", "Devine le slogan",  "The Walking Dead", "Breaking Bad", "Harry Potter", "Deadpool"};
    TextView country, userMail, hightScoreSnk;
    Locale locale;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getEmail();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        listCategory = findViewById(R.id.listCategory);
        country = findViewById(R.id.country);
        userMail = findViewById(R.id.userMail);
        hightScoreSnk = findViewById(R.id.score);
        //loadHighscore();
        locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        country.setText(locale.getDisplayCountry());
        userMail.setText(uid);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listCategory.setAdapter(adapter);

        listCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        hightScoreSnk.setText("histoire");
                        break;
                    case 1:
                        hightScoreSnk.setText("geo");
                        break;
                    case 2:
                        hightScoreSnk.setText("snk");
                        break;
                    case 3:
                        hightScoreSnk.setText("pkm");
                        break;
                    case 4:
                        hightScoreSnk.setText("tokyo");
                        break;
                    case 5:
                        hightScoreSnk.setText("mha");
                        break;
                    case 6:
                        hightScoreSnk.setText("op");
                        break;
                    case 7:
                        hightScoreSnk.setText("logo");
                        break;
                    case 8:
                        hightScoreSnk.setText("slogan");
                        break;
                    case 9:
                        hightScoreSnk.setText("twd");
                        break;
                    case 10:
                        hightScoreSnk.setText("bb");
                        break;
                    case 11:
                        hightScoreSnk.setText("hp");
                        break;
                    case 12:
                        hightScoreSnk.setText("deadpool");
                        break;
                }
            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){

            }

        });

    }
    public void goBack(View v){ startActivity(new Intent(getApplicationContext(), MainActivity.class)); finish();}
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == REQUEST_CODE_QUIZ){
            if ( resultCode == RESULT_OK){
                int score = data.getIntExtra(AttackOnTitan.EXTRA_SCORE, 0);
                if (score > highScore){
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highScore = prefs.getInt(KEY_HIGHSCORE, 0);
        hightScoreSnk.setText(highScore);
    }

    private void updateHighscore(int highscoreNew){
        highScore = highscoreNew;
        hightScoreSnk.setText(highScore);

        SharedPreferences pref = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(KEY_HIGHSCORE, highScore);
        editor.apply();
    }*/
}